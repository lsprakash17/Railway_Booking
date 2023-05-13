package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Train;
import dto.TrainTicket;

public class TrainDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void save(Train train) {
		transaction.begin();
		manager.persist(train);
		transaction.commit();
	}
	public List<Train> Fetchall()
	{
		return manager.createQuery("select a from Train a").getResultList();
	}
	public void Delete(int id) {
		transaction.begin();
		
		manager.remove(manager.find(Train.class, id));
		transaction.commit();
	}

	public Train find(int num)
	{
		return manager.find(Train.class, num);
	}
	public void Update(Train train) {
		transaction.begin();
		manager.merge(train);
		transaction.commit();
	}
	public void sav(TrainTicket ticket) {
		transaction.begin();
		manager.persist(ticket);
		transaction.commit();
	}
	public TrainTicket fetchTicket(int pnr)
	{
		return manager.find(TrainTicket.class, pnr);
	}

	public void update(TrainTicket ticket) {
		transaction.begin();
		manager.merge(ticket);
		transaction.commit();
	}
}