package com.xworkz.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xworkz.entity.BikeEntity;

@Repository
public class BikeDAOImpl implements BikeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BikeDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + "Invoked");
	}

	@Override
	public boolean saveBikeEntity(BikeEntity bikeEntity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(bikeEntity);
			transaction.commit();
			System.out.println("bike entity is saved");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.clear();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}

	@Override
	public BikeEntity findBikeEntity(String bikeName) {
		System.out.println("findBikeEntity invoked from " + this.getClass().getSimpleName());
		Session session = null;
		BikeEntity bikeEntity = null;

		try {
			session = sessionFactory.openSession();
			Query query = session.createNamedQuery("BikeEntity.findBikeEntity");
			query.setParameter("BIKENAME", bikeName);
			Object object = query.uniqueResult();
			bikeEntity = (BikeEntity) object;
			if (bikeEntity != null) {
				return bikeEntity;
			} else {
				System.out.println("bike entity not found");
			}

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}

		}

		return bikeEntity;
	}

	@Override
	public List<BikeEntity> getListOfBikeEntity() {

		System.out.println("getListOfBikeEntity invoked from " + this.getClass().getSimpleName());
		Session session = null;
		List<BikeEntity> list = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createNamedQuery("BikeEntity.getAllBike");
			list = query.list();
			if (list.size()>0 && list!=null) {
				return list;
			} else {
				System.out.println("Table is empty");
			}
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}

		}

		return list;
	}

	@Override
	public boolean deleteBikeByName(String bikeName) {

		System.out.println("getListOfBikeEntity invoked from " + this.getClass().getSimpleName());
		Session session = null;
		Transaction transaction=null;
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query = session.createNamedQuery("BikeEntity.deleteBikeByName");
			query.setParameter("DELETEBIKE", bikeName);
			query.executeUpdate();
			transaction.commit();
			System.out.println("successfully deleted");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}

		}

		return false ;
	}

	@Override
	public boolean updateBikeByBikeName(BikeEntity bikeEntity) {

		System.out.println("updateBikeByBikeName invoked from " + this.getClass().getSimpleName());
		Session session = null;
		Transaction transaction=null;
		boolean isBikeEntityUpdated=false;
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query = session.createNamedQuery("BikeEntity.updateBikeByBikeName");
			query.setParameter("BIKENAME", bikeEntity.getBikeName());
			query.setParameter("BIKECOLOR", bikeEntity.getBikeColor());
			query.setParameter("BIKEBRAND", bikeEntity.getBikeBrand());
			query.setParameter("BIKECOST", bikeEntity.getBikeCost());
			query.setParameter("BIKETYPE", bikeEntity.getBikeType());
			query.executeUpdate();
			transaction.commit();
			isBikeEntityUpdated=true;
			return isBikeEntityUpdated;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}

		}

		return isBikeEntityUpdated  ;
	}

}
