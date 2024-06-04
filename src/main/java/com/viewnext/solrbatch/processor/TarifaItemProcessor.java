package com.viewnext.solrbatch.processor;

import org.apache.solr.common.SolrInputDocument;
import org.springframework.batch.item.ItemProcessor;

import com.viewnext.solrbatch.model.Tarifa;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TarifaItemProcessor implements ItemProcessor<Tarifa, SolrInputDocument> {

	@Override
	public SolrInputDocument process(Tarifa item) throws Exception {

		log.info("Procesando...");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", item.getId());
		document.addField("nombre", item.getNombre());
		document.addField("precio", item.getPrecio());
		document.addField("movimiento", item.getIva());

		return document;
	}
}
