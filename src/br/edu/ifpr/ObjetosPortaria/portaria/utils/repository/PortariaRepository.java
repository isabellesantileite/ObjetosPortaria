package br.edu.ifpr.ObjetosPortaria.portaria.utils.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifpr.ObjetosPortaria.portaria.utils.*;

public enum PortariaRepository {
   INSTANCE; // Única instância do singleton

   private final List<Portaria> portarias = new ArrayList<>();

   PortariaRepository() {
      // incluir vários objetos Portaria no "banco de dados"
	   portarias.add(new Portaria("IFPR", 27, LocalDate.of(2009, 8, 30), "Pedro Henrique Assis"));
       portarias.add(new Portaria("MEC", 4, LocalDate.of(2012, 5, 21), "Josefa Isabelly Santos Habermann"));
       portarias.add(new Portaria("UEL", 54, LocalDate.of(2014, 4, 12), "Lucca Erick Bento Assis"));
       portarias.add(new Portaria("Unicamp", 78, LocalDate.of(2013, 9, 13), "Bento Pietro Jorge Ribeiro"));
       portarias.add(new Portaria("UTFPR", 21, LocalDate.of(2011, 2, 17), "Lorena Tatiane Jaqueline Araújo"));
       portarias.add(new Portaria("UEM", 93, LocalDate.of(2016, 7, 25), "Josefina Antonella Monteiro"));
   }
   
   public List<Portaria> getPortarias(){
	   return portarias;
   }
   /*os objetos não podem ter o mesmo numero
    * numero = primary key*/

   public synchronized boolean inserir(Portaria portaria) {
	   //eu só posso inserir objetos de numeros diferentes daqueles que ja pertencem ao BD 
	   //portarias.add é reconhecido como true
	   for(Portaria p : this.portarias) {
		   if(portaria.getNumero().intValue() == p.getNumero().intValue())
			   return false;
	   }	 
	   return this.portarias.add(portaria);
   }

   public synchronized boolean alterar(Portaria portaria) {
	   /*altera o elemento portaria passado como parametro*/
	   int i = 0;
	   for(Portaria p : portarias) {
		   if(portaria.getNumero().intValue() == p.getNumero().intValue()) {
			   portarias.set(i, portaria);
			   return true;
		   }
		   i++;
	   }
	   return false;
   }

   public synchronized boolean excluir(Integer num) {
	   /*exclui o elemento portaria que tem o numero igual ao passado como parametro*/
	   int i = 0;
	   for(Portaria portaria : portarias) {
		   if(portaria.getNumero() == num) {
			   portarias.remove(i);
			   return true;
		   }
		   i++;
	   }
	   return false;
   }

   public Optional<Portaria> buscarPorEmissor(String emissor) {
	   /*retorna o objeto portaria com o emissor passado como parametro
	    * ou retorna "null" caso nao o encontre (por isso, Optional)*/
	  for(Portaria portaria : portarias) {
		  if(portaria.getEmissor() == emissor)
			  return Optional.of(portaria);
	  }
      return Optional.empty();
   }

   public Optional<Portaria> buscarPorNumero(Integer number) {
	   /*retorna o objeto portaria com o numero passado como parametro
	    * ou retorna "null" caso nao o encontre (por isso, Optional)*/
	  for(Portaria portaria : portarias) {
		  if(portaria.getNumero() == number)
			  return Optional.of(portaria);
	  }
	  return Optional.empty();
   }

   public List<Portaria> buscarPorPeríodo(LocalDate start, LocalDate end) {
	   /*inclui em uma nova colecao todos os objetos portaria que tem a 
	    * publicacao dentro do periodo passado como parametro*/
	   List<Portaria> portariaPorPeríodo = new ArrayList<>();
	   for(Portaria portaria : portarias) {
		   if(portaria.getPublicacao().isAfter(start) && portaria.getPublicacao().isBefore(end)){
			   portariaPorPeríodo.add(portaria);
		   }
	   }
	   return portariaPorPeríodo;
   }

   public List<Portaria> buscarPorPublicação(LocalDate start) {
	   /*inclui em uma nova colecao todos os objetos portaria que tem a 
	    * publicacao passada como parametro*/
	   List<Portaria> portariaPorPublicação = new ArrayList<>();
	   for(Portaria portaria : portarias) {
		   if(portaria.getPublicacao().equals(start)){
			   portariaPorPublicação.add(portaria);
		   }
	   }
	   return portariaPorPublicação;	   
   }

   public List<Portaria> buscarPorNome(String nome) {
	   /*inclui em uma nova colecao todos os objetos portaria que tem a 
	    * o nome passado como parametro*/
	   List<Portaria> portariaPorNome = new ArrayList<>();
	   for(Portaria portaria : portarias) {
		   if(portaria.getMembro().equals(nome)){
			   portariaPorNome.add(portaria);
		   }
	   }
	   return portariaPorNome;   
}

   public List<Portaria> listarTodas() {
	   //lista os objetos portaria
	   List<Portaria> portariaCopia = new ArrayList<>(portarias);
	   return portariaCopia;
   }

}
