package com.github.wesleyegberto.springmvc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.wesleyegberto.springmvc.metrics.RequestCounter;

@Component
@WebFilter(urlPatterns = { "/api" }, asyncSupported = true)
public class CounterFilter implements Filter {
	private RequestCounter counter;

	@Autowired
	public CounterFilter(RequestCounter counter) {
		this.counter = counter;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		counter.increment();
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
