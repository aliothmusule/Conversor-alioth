package com.modelo;

public class Moneda {
	private Integer id;
	private String nombre;
	private Double valorEnDolar;
	private char signo;
	
	public Moneda(Integer id, String nombre, Double valorEnDolar, char signo ) {
		this.id = id;
		this.nombre = nombre;
		this.valorEnDolar = valorEnDolar;
		this.signo = signo;
		}

	public Moneda() {	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getValorEnDolar() {
		return valorEnDolar;
	}
	public void setValorEnDolar(Double valorEnDolar) {
		this.valorEnDolar = valorEnDolar;
	}
	
	public char getSigno() {
		return signo;
	}

	public void setSigno(char signo) {
		this.signo = signo;
	}

	@Override
	public String toString() {
		return getNombre();
	}
}
