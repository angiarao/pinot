package com.linkedin.pinot.common.metrics;

import com.yammer.metrics.core.MetricName;
import com.yammer.metrics.core.MetricsRegistry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.MapConfiguration;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Tests for the MetricsHelper class.
 *
 * @author jfim
 */
public class TestMetricsHelper {
  public static boolean listenerOneOkay;
  public static boolean listenerTwoOkay;

  public static class ListenerOne implements MetricsRegistryRegistrationListener {
    @Override
    public void onMetricsRegistryRegistered(MetricsRegistry metricsRegistry) {
      listenerOneOkay = true;
    }
  }

  public static class ListenerTwo implements MetricsRegistryRegistrationListener {
    @Override
    public void onMetricsRegistryRegistered(MetricsRegistry metricsRegistry) {
      listenerTwoOkay = true;
    }
  }

  @Test
  public void testMetricsHelperRegistration() {
    listenerOneOkay = false;
    listenerTwoOkay = false;

    Map<String, String> configKeys = new HashMap<String, String>();
    configKeys.put("pinot.broker.metrics.metricsRegistryRegistrationListeners",
        ListenerOne.class.getName() + "," + ListenerTwo.class.getName());
    Configuration configuration = new MapConfiguration(configKeys);

    MetricsRegistry registry = new MetricsRegistry();

    // Initialize the MetricsHelper and create a new timer
    MetricsHelper.initializeMetrics(configuration.subset("pinot.broker.metrics"));
    MetricsHelper.registerMetricsRegistry(registry);
    MetricsHelper.newTimer(registry, new MetricName(TestMetricsHelper.class, "dummy"), TimeUnit.MILLISECONDS, TimeUnit.MILLISECONDS);

    // Check that the two listeners fired
    assertTrue(listenerOneOkay);
    assertTrue(listenerTwoOkay);
  }
}