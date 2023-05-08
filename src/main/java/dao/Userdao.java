package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.User;

public class Userdao 
{
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction= entityManager.getTransaction();
public void save(User user)
{
	entityTransaction.begin();
	entityManager.persist(user);
	entityTransaction.commit();
}
public User find(int userid)
{
	return entityManager.find(User.class, userid);
}
public void update(User user) {
	entityTransaction.begin();
	entityManager.merge(user);
	entityTransaction.commit();
	
}
}
