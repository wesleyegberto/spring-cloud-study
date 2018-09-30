package com.github.wesleyegberto.springmvc.metrics;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class RequestCounter {
	private Counter counter;

	public RequestCounter(MeterRegistry registry) {
		this.counter = registry.counter("requests.counter");
	}
	
	public void increment() {
		this.counter.increment();
	}
}
