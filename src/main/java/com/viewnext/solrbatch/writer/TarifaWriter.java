package com.viewnext.solrbatch.writer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Component
@Slf4j
public class TarifaWriter {

	@Bean(value = "writerSolr")
	public TarifaItemWriter writerLocal() {
		log.info("Escribiendo items...");

		return new TarifaItemWriter();
	}
}
