/*Crie um programa Java contendo, entre outras, uma classe que descreve um documento denominado portaria
 * com os seguintes atributos:
 * emissor String(nome do órgão que publica portaria)
 * numero Ineger-inteiro
 * publicacao LocalDate
 * membro String(pessoa que está na portaria)
 * 
 * O programa principal deve criar varios objetos portaria e armazená-los em uma coleção.
 * O programa deve ser capaz de ordenar a coleção por emissor ou número. 
 * Pesquise sobre a interface Comparator
 * Usar DateTimeFormatter para corrigir data*/

package br.edu.ifpr.ObjetosPortaria.portaria.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Portaria {
	DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private String emissor;
	private Integer numero;
	private LocalDate publicacao;
	private String membro;
	
	public Portaria() {}
	public Portaria(String emissor, Integer numero, LocalDate publicacao, String membro) {
		this.emissor = emissor;
		this.numero = numero;
		this.publicacao = publicacao;
		this.membro = membro;
	}
	
	public String getEmissor() { 
		return emissor; }
	public void setEmissor(String emissor) {
		this.emissor = emissor; }
	public Integer getNumero() {
		return numero; }
	public void setNumero(Integer numero) {
		this.numero = numero; }
	public LocalDate getPublicacao() {
		return publicacao; }
	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}
	public String getMembro() {
		return membro; }
	public void setMembro(String membro) {
		this.membro = membro; }
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		if (this == obj) return true;
		
		Portaria p = (Portaria) obj;//conversão do tipo Object para Portaria
		if (!this.emissor.equals(p.emissor)) return false;
		if (!this.numero.equals(p.numero)) return false;
		if (!this.publicacao.equals(p.publicacao)) return false;
		if (!this.membro.equals(p.membro)) return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Portaria[emissor = " + emissor + ", numero = " + numero +", publicacao = "
				+ publicacao.format(customFormatter)+ ", membro = " + membro + "]";
	}
}

