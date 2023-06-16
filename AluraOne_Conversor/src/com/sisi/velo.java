package com.sisi;

import java.util.ArrayList;
import java.util.List;


import com.modelo.Velocidad;

public class velo {
	
	// private List<Moneda> listaMonedas = new ArrayList<>();
	private List<Velocidad> velocidades;
	
	public velo() {
		velocidades = new ArrayList<>();
		// Agregamos algunas monedas a la lista
		Velocidad metroPorSeg = new Velocidad(1, "Metro/Segundo", 1.0, "m/s");
		Velocidad kmPorHora = new Velocidad(2, "Kilometro/Hora", 3.6, "km/h");
		Velocidad millaPorHora = new Velocidad(3, "Milla/Hora", 2.23694, "milla/h");
		Velocidad piePorSeg = new Velocidad(4, "Pie/Segundo", 3.28084, "pie/s");
		Velocidad nudo = new Velocidad(5, "Nudo", 1.94384, "nudos");
		Velocidad kmPorSeg = new Velocidad(6, "Kilometro/Segundo", 0.001, "km/s");

		velocidades.add(metroPorSeg);
		velocidades.add(kmPorHora);
		velocidades.add(millaPorHora);
		velocidades.add(piePorSeg);
		velocidades.add(nudo);
		velocidades.add(kmPorSeg);
	
	}

	public List<Velocidad> getVelocidades() {
		return velocidades;
	}	
	
	public Double conversorVelocidades(Double valor, Double velocidad1, Double velocidad2) {
		Double conversion = valor / velocidad1*velocidad2;
		return conversion;
	}
}

