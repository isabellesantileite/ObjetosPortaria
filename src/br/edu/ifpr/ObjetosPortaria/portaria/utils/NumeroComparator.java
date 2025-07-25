package br.edu.ifpr.ObjetosPortaria.portaria.utils;

import java.util.Comparator;

public class NumeroComparator implements Comparator<Portaria> {
	@Override
	public int compare (Portaria o1, Portaria o2) {
		int o1Numero = o1.getNumero().intValue();
		int o2Numero = o2.getNumero().intValue();
		
		if (o1Numero < o2Numero) return -1;
		else 
			if (o1Numero > o2Numero) return 1;
		
		return 0;
	}
}
