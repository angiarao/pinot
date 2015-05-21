/**
 * Copyright (C) 2014-2015 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.controller.helix;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.helix.manager.zk.ZkClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.linkedin.pinot.common.ZkTestUtils;
import com.linkedin.pinot.common.segment.SegmentMetadata;
import com.linkedin.pinot.common.utils.CommonConstants;
import com.linkedin.pinot.controller.helix.core.PinotHelixResourceManager;
import com.linkedin.pinot.core.query.utils.SimpleSegmentMetadata;


public class ControllerSentinelTestV2 extends ControllerTest {

  private static final String HELIX_CLUSTER_NAME = "ControllerSentinelTestV2";
  static ZkClient _zkClient = null;

  private PinotHelixResourceManager _pinotResourceManager;

  @BeforeClass
  public void setup() throws Exception {
    startZk();
    _zkClient = new ZkClient(ZkTestUtils.DEFAULT_ZK_STR);
    startController();
    _pinotResourceManager = _controllerStarter.getHelixResourceManager();
    ControllerRequestBuilderUtil.addFakeBrokerInstancesToAutoJoinHelixCluster(HELIX_CLUSTER_NAME, ZkTestUtils.DEFAULT_ZK_STR, 20);
    ControllerRequestBuilderUtil.addFakeDataInstancesToAutoJoinHelixCluster(HELIX_CLUSTER_NAME, ZkTestUtils.DEFAULT_ZK_STR, 20);
  }

  @AfterClass
  public void tearDown() {
    stopController();
    try {
      if (_zkClient.exists("/ControllerSentinelTest")) {
        _zkClient.deleteRecursive("/ControllerSentinelTest");
      }
    } catch (Exception e) {
    }
    _zkClient.close();
    stopZk();
  }

  @Test
  public void testOfflineTableLifeCycle() throws JSONException, UnsupportedEncodingException, IOException {
    // Create broker tenant creation request
    String brokerTenant = "testBrokerTenant";
    JSONObject payload = ControllerRequestBuilderUtil.buildBrokerTenantCreateRequestJSON(brokerTenant, 5);
    sendPostRequest(ControllerRequestURLBuilder.baseUrl(CONTROLLER_BASE_API_URL).forTenantCreate(), payload.toString());
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, brokerTenant + "_BROKER").size(), 5);
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, CommonConstants.Helix.UNTAGGED_BROKER_INSTANCE).size(), 15);

    // Create server tenant creation request
    String serverTenant = "testServerTenant";
    payload = ControllerRequestBuilderUtil.buildServerTenantCreateRequestJSON(serverTenant, 6, 3, 3);
    sendPostRequest(ControllerRequestURLBuilder.baseUrl(CONTROLLER_BASE_API_URL).forTenantCreate(), payload.toString());
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, serverTenant + "_REALTIME").size(), 3);
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, serverTenant + "_OFFLINE").size(), 3);
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, CommonConstants.Helix.UNTAGGED_SERVER_INSTANCE).size(), 14);

    // Create offline table creation request
    String tableName = "testTable";
    payload = ControllerRequestBuilderUtil.buildCreateOfflineTableV2JSON(tableName, serverTenant, brokerTenant, 3);
    sendPostRequest(ControllerRequestURLBuilder.baseUrl(CONTROLLER_BASE_API_URL).forTableCreate(), payload.toString());
    Assert.assertEquals(_helixAdmin.getResourceIdealState(HELIX_CLUSTER_NAME, CommonConstants.Helix.BROKER_RESOURCE_INSTANCE).getPartitionSet().size(), 1);
    Assert.assertEquals(_helixAdmin.getResourceIdealState(HELIX_CLUSTER_NAME, CommonConstants.Helix.BROKER_RESOURCE_INSTANCE).getInstanceSet(tableName + "_OFFLINE").size(), 5);

    // Adding segments
    for (int i = 0; i < 10; ++i) {
      Assert.assertEquals(_helixAdmin.getResourceIdealState(HELIX_CLUSTER_NAME, tableName + "_OFFLINE").getNumPartitions(), i);
      addOneOfflineSegment(tableName);
      Assert.assertEquals(_helixAdmin.getResourceIdealState(HELIX_CLUSTER_NAME, tableName + "_OFFLINE").getNumPartitions(), i + 1);
    }

    // Delete table
    sendDeleteRequest(ControllerRequestURLBuilder.baseUrl(CONTROLLER_BASE_API_URL).forTableDelete(tableName));
    Assert.assertEquals(_helixAdmin.getResourceIdealState(HELIX_CLUSTER_NAME, CommonConstants.Helix.BROKER_RESOURCE_INSTANCE).getPartitionSet().size(), 0);

    // Delete broker tenant
    sendDeleteRequest(ControllerRequestURLBuilder.baseUrl(CONTROLLER_BASE_API_URL).forBrokerTenantCreate(brokerTenant));
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, brokerTenant + "_BROKER").size(), 0);
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, CommonConstants.Helix.UNTAGGED_BROKER_INSTANCE).size(), 20);

    // Delete server tenant
    sendDeleteRequest(ControllerRequestURLBuilder.baseUrl(CONTROLLER_BASE_API_URL).forServerTenantCreate(serverTenant));
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, serverTenant + "_REALTIME").size(), 0);
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, serverTenant + "_OFFLINE").size(), 0);
    Assert.assertEquals(_helixAdmin.getInstancesInClusterWithTag(HELIX_CLUSTER_NAME, CommonConstants.Helix.UNTAGGED_SERVER_INSTANCE).size(), 20);
  }

  private void addOneOfflineSegment(String resourceName) {
    final SegmentMetadata segmentMetadata = new SimpleSegmentMetadata(resourceName);
    _pinotResourceManager.addSegmentV2(segmentMetadata, "downloadUrl");
  }

  @Override
  protected String getHelixClusterName() {
    return HELIX_CLUSTER_NAME;
  }

}