package com.course.me.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketConfiguration {

	@Bean
	Filter getFilter() {
		return new MyFilter();
	}
}
