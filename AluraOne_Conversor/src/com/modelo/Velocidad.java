package com.modelo;

public class Velocidad {
	private Integer id;
	private String unidadMedida;
	private Double valorEnMetroPorSeg;
	private String unidades;
	
	public Velocidad(Integer id, String unidadMedida, Double valorEnMetroPorSeg, String unidades) {
		this.id = id;
		this.unidadMedida = unidadMedida;
		this.valorEnMetroPorSeg = valorEnMetroPorSeg;
		this.unidades = unidades;
	}

	public Velocidad() {  }
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Double getValorEnMetroPorSeg() {
		return valorEnMetroPorSeg;
	}

	public void setValorEnMetroPorSeg(Double valorEnMetroPorSeg) {
		this.valorEnMetroPorSeg = valorEnMetroPorSeg;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}
	
	@Override
	public String toString() {
		return getUnidadMedida();
	}
}

