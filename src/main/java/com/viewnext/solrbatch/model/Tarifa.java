package com.viewnext.solrbatch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Tarifa {

	private Long id;
	private String nombre;
	private Double precio;
	private Double iva;

}
