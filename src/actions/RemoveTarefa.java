package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tarefa;

public class RemoveTarefa {
	public static void main(String[] args) {
		Tarefa tarefa1 = new Tarefa();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		
		EntityManager manager = factory.createEntityManager();
		
		tarefa1.setId(1L);
		tarefa1 = manager.find(Tarefa.class, 1L);
		
		manager.getTransaction().begin();
		manager.remove(tarefa1);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa excluida!");
		
		manager.close();
		factory.close();
		
	}
}
