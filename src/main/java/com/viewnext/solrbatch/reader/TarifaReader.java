package com.viewnext.solrbatch.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.viewnext.solrbatch.model.Tarifa;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Component
@Slf4j
public class TarifaReader {

	/**
	 * Método que configura y devuelve un JdbcCursorItemReader para leer objetos
	 * {@link Tarifas} desde una base de datos. Utiliza un DataSource para acceder a
	 * la base de datos.
	 * 
	 * @param dataSource El DataSource que proporciona la conexión a la base de
	 *                   datos.
	 * @return Un JdbcCursorItemReader configurado para leer objetos Tarifas desde
	 *         una base de datos.
	 * 
	 * 
	 */

	@Bean(value = "readerSolr")
	public JdbcCursorItemReader<Tarifa> itemReader(DataSource dataSource) {
		JdbcCursorItemReader<Tarifa> itemReader = new JdbcCursorItemReader<>();
		itemReader.setName("tarifasItemReader");
		itemReader.setDataSource(dataSource);
		itemReader.setSql("SELECT * FROM TARIFAS");
		itemReader.setRowMapper((rs, rowNum) -> {
			Tarifa tarifas = new Tarifa();
			tarifas.setId(rs.getLong("ID"));
			tarifas.setNombre(rs.getString("NOMBRE"));
			tarifas.setPrecio(rs.getDouble("PRECIO"));
			tarifas.setIva(rs.getDouble("IVA"));
			return tarifas;
		});
		log.info("ARCHIVO LEÍDO CORRECTAMENTE");
		return itemReader;
	}

	/*
	 * @Bean(value = "readerDB") public JdbcCursorItemReader<Tarifa> read(DataSource
	 * dataSource) { JdbcCursorItemReader<Tarifa> itemReader = new
	 * JdbcCursorItemReader<>(); itemReader.setDataSource(dataSource);
	 * itemReader.setSql("SELECT id, nombre, precio, iva from tarifas");
	 * itemReader.setRowMapper(createRowMapper());
	 * 
	 * log.info("<--- Leyendo tarifas --->"); return itemReader; } private
	 * RowMapper<Personaje> createRowMapper(){ return new RowMapper<Personaje>() {
	 * 
	 * @Override public Personaje mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { return new Personaje(rs.getLong("id"), rs.getString("nombre"),
	 * rs.getInt("vida"), rs.getInt("movimiento"), rs.getInt("armadura")); } }; }
	 */
}
