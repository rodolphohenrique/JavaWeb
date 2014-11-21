import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Principal {
	
	
	
	public static void main(String[] args) {
		
		Produto p = new Produto();
		p.setNome(Console.readString("Digite um nome: "));
		p.setDescricao(Console.readString("Digite uma descrição: "));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(p);
		tx.commit();
		
		Query q = em.createQuery("SELECT p FROM Produto p");
		List <Produto> produtos = q.getResultList();
		
		for(Produto prod: produtos){
			System.out.println(prod.getNome());
		}
		
		em.close();
		emf.close();
		
		
	}

}
