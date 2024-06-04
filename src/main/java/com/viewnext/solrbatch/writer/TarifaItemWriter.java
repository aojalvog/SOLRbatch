package com.viewnext.solrbatch.writer;

import java.util.Collection;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

public class TarifaItemWriter implements ItemWriter<SolrInputDocument> {

	@Autowired
	private SolrClient solrClient;

	@Override
	public void write(@NonNull Chunk<? extends SolrInputDocument> chunk) throws Exception {
		solrClient.add((Collection<SolrInputDocument>) chunk.getItems());
		solrClient.commit();

	}

}
