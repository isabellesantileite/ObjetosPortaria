package br.edu.ifpr.ObjetosPortaria.portaria.utils;

import java.util.Comparator;

public class EmissorComparator implements Comparator<Portaria> {
	@Override
	public int compare (Portaria o1, Portaria o2) {
		return o1.getEmissor().compareTo(o2.getEmissor());
	}
}
