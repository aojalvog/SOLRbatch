package com.viewnext.solrbatch.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpJdkSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrConfig {

	@Bean("collectionTarifas")
	public SolrClient solrClient() {
		return new HttpJdkSolrClient.Builder("http://localhost:9200/solr/tarifas").build();
	}
}
