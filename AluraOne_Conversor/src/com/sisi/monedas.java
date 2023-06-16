package com.sisi;

import java.util.ArrayList;
import java.util.List;


import com.modelo.Moneda;

public class monedas {
	
	// private List<Moneda> listaMonedas = new ArrayList<>();
	private List<Moneda> monedas;
	
	public monedas() {
		monedas = new ArrayList<>();
		// Agregamos algunas monedas a la lista
		Moneda colonSv = new Moneda(1, "Colon Salvadoreño", 8.74, '₡');
		Moneda dolar = new Moneda(2, "Dolar", 1.0, '$');
		Moneda euro = new Moneda(3, "Euro", 0.91, '€');
		Moneda libraEsterlina = new Moneda(4, "Libra Esterlina", 0.8, '£');
		Moneda yen = new Moneda(5, "Yen", 135.85, '¥');
		Moneda wonSurcoreano = new Moneda(6, "Won Surcoreano", 1334.02, '₩');

		monedas.add(colonSv);
		monedas.add(dolar);
		monedas.add(euro);
		monedas.add(libraEsterlina);
		monedas.add(yen);
		monedas.add(wonSurcoreano);
	
	}

	public List<Moneda> getMonedas() {
		return monedas;
	}	
	
	public Double conversorMonedas(Double valor, Double moneda1, Double moneda2) {
		Double conversion = valor / moneda1*moneda2;
		return conversion;
	}
}

