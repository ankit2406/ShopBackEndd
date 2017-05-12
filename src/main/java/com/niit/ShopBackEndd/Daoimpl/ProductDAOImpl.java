package com.niit.ShopBackEndd.Daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ShopBackEndd.Dao.ProductDAO;
import com.niit.ShopBackEndd.Domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean createProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateProduct(Product product) {

		try {
			sessionFactory.getCurrentSession().update(product);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();

	}

	public Product get(long id) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where id='" + id + "'").uniqueResult();
	}

	@Override
	public List<Product> getSimilarProducts(String search_string) {
	return	sessionFactory.getCurrentSession().createQuery("from Product where name like '%?%' ").setString(0, search_string).list();
	
	}
}