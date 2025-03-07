/*
 * Copyright Splunk Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.splunk.opentelemetry.testing;

import io.micrometer.core.instrument.Metrics;
import java.util.Set;
import java.util.stream.Collectors;

/** This class is used in instrumentation tests; accessed via agent classloader bridging. */
@SuppressWarnings("unused")
public final class TestMetrics {
  public static Set<String> getMeterNames() {
    return Metrics.globalRegistry.getMeters().stream()
        .map(meter -> meter.getId().getName())
        .collect(Collectors.toSet());
  }

  private TestMetrics() {}
}
