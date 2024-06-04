package com.viewnext.solrbatch.config;

import org.apache.solr.common.SolrInputDocument;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.viewnext.solrbatch.model.Tarifa;
import com.viewnext.solrbatch.processor.TarifaItemProcessor;
import com.viewnext.solrbatch.writer.TarifaItemWriter;

@Configuration
public class BatchConfig {

	@Bean
	Job job(JobRepository jobRepository, Step step1) {
		return new JobBuilder("db-to-csv", jobRepository).start(step1).build();
	}

	@Bean
	public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			@Qualifier("readerSolr") JdbcCursorItemReader<Tarifa> reader, TarifaItemProcessor processor,
			@Qualifier("writerSolr") TarifaItemWriter writer) {
		return new StepBuilder("step1", jobRepository).<Tarifa, SolrInputDocument>chunk(3, transactionManager)
				.allowStartIfComplete(true).reader(reader).processor(processor).writer(writer).build();
	}
}
