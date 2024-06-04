package com.viewnext.solrbatch.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class TarifaProcessor {

	@Bean(value = "processor")
	TarifaItemProcessor itemProcessor() {
		return new TarifaItemProcessor();
	}

}
