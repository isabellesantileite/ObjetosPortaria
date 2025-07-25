/* Crie um programa Java contendo, entre outras, uma classe que descreve um documento denominado portaria
 * com os seguintes atributos:
 * emissor String(nome do órgão que publica portaria)
 * numero Ineger-inteiro
 * publicacao LocalDate
 * membro String
 * 
 * O programa principal deve criar varios objetos portaria e armazená-los em uma coleção. Mostrar ao 
 * usuário.
 * O programa deve ser capaz de ordenar a coleção por emissor ou número. 
 * Pesquise sobre a interface Comparator
 * Incluir os métodos da classe repository*/

package br.edu.ifpr.ObjetosPortaria.aplicacao;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import br.edu.ifpr.ObjetosPortaria.portaria.utils.EmissorComparator;
import br.edu.ifpr.ObjetosPortaria.portaria.utils.NumeroComparator;
import br.edu.ifpr.ObjetosPortaria.portaria.utils.Portaria;
import br.edu.ifpr.ObjetosPortaria.portaria.utils.repository.PortariaRepository;

public class ObjetosPortariaPrincipal {
	private PortariaRepository repo = PortariaRepository.INSTANCE;
		
	private void mostrar(List<Portaria> p) {
		for (Portaria portaria : p)
			System.out.println(portaria.toString());
	}
	
    private ObjetosPortariaPrincipal() {
    	mostrar(repo.listarTodas());
    	Collections.sort(repo.getPortarias(), new EmissorComparator());
    	System.out.println("\n==> ORDENADO (Emissor) <==");
    	mostrar(repo.listarTodas());
    	
    	Collections.sort(repo.getPortarias(), new NumeroComparator());
    	System.out.println("\n==> ORDENADO (Numero) <==");
    	mostrar(repo.listarTodas());
    	
    	System.out.println("\n==> MÉTODO INSERIR <==");
    	repo.inserir(new Portaria("UEM", 45, LocalDate.of(2001, 11, 9), "Celso Portiolli"));
    	mostrar(repo.listarTodas());
    	
    	System.out.println("\n==> MÉTODO BUSCARPOREMISSOR <==");
    	System.out.println(repo.buscarPorEmissor("UNIMARA"));
    	
    	System.out.println("\n==> MÉTODO ALTERAR <==");
    	repo.alterar(new Portaria("IFPR", 27, LocalDate.of(2008, 8, 30), "Pietro Mário Gustavo Brito"));
    	mostrar(repo.listarTodas());
    	
    	System.out.println("\n==> MÉTODO EXCLUIR <==");
    	repo.excluir(45);
    	mostrar(repo.listarTodas());
    	
    	System.out.println("\n==> MÉTODO BUSCARPOREMISSOR <==");
    	System.out.println(repo.buscarPorEmissor("IFPR"));
    	
    	System.out.println("\n==> MÉTODO BUSCARPORNUMERO <==");
    	System.out.println(repo.buscarPorNumero(4));
    	
    	LocalDate start = LocalDate.of(2008, 8, 30);
    	LocalDate end = LocalDate.of(2021, 3, 9);
    	System.out.println("\n==> MÉTODO BUSCARPORPERIODO <==");
    	System.out.println("\nPERIODO: " + start + " a " + end);
    	mostrar(repo.buscarPorPeríodo(start, end));
    	
    	System.out.println("\n==> MÉTODO BUSCARPORPUBLICACAO <==");
    	mostrar(repo.buscarPorPublicação(start));
    	
    	System.out.println("\n==> MÉTODO BUSCARPORNOME <==");
    	mostrar(repo.buscarPorNome("Josefina Antonella Monteiro"));
    	
    	System.out.println("\n==> MÉTODO LISTARTODAS <==");
    	mostrar(repo.listarTodas());
    	}
    
    public static void main(String[] args) 
    {
    	new ObjetosPortariaPrincipal();
    }
}