package www.btl.DAO.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.btl.Entity.Categories;
import www.btl.Entity.Product;
import www.btn.DAO.ProductDao;

@Repository
public class ProductDaoimpl implements ProductDao {

	@Autowired
	public SessionFactory factory;

	@Override
	@Transactional
	public boolean save(Product product) {
		factory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@Override
	@Transactional
	public List<Product> getAllProduct(int page) {
		List<Product> list = new ArrayList<>();

		NativeQuery<Object[]> query = (NativeQuery<Object[]>) factory.getCurrentSession()
				.createNativeQuery("SELECT *\n" + "FROM products\n" + "ORDER BY product_id\n" + "OFFSET " + page
						+ " ROWS\n" + "FETCH NEXT 6 ROW ONLY;");

		for (Object[] o : query.getResultList()) {
			List<String> listimg = new ArrayList<String>();
			NativeQuery<Object[]> query1 = (NativeQuery<Object[]>) factory.getCurrentSession()
					.createNativeQuery("SELECT * from list_images WHERE product_id = " + o[0]);
//			System.out.println("SELECT * from list_images WHERE product_id = " + o[0]);

			for (Object[] o1 : query1.getResultList()) {
				listimg.add((String) o1[1]);
			}
			list.add(new Product((int) o[0], (String) o[3], new Categories((int) o[7]), (String) o[2], listimg,
					(double) o[4], (boolean) o[1], (String) o[5], (int) o[6]));
		}
		return list;
	}

	@Override
	@Transactional
	public boolean update(Product product) {
		factory.getCurrentSession().update(product);
		return true;
	}

	@Override
	@Transactional
	public boolean delete(Product product) {
		factory.getCurrentSession().delete(product);
		return true;

	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		Product p = null;
		NativeQuery<Object[]> query = (NativeQuery<Object[]>) factory.getCurrentSession()
				.createNativeQuery("select * from products where product_id = " + id);
		System.out.println(query.getResultList());
		for (Object[] o : query.getResultList()) {
			List<String> listimg = new ArrayList<String>();
			NativeQuery<Object[]> query1 = (NativeQuery<Object[]>) factory.getCurrentSession()
					.createNativeQuery("SELECT * from list_images WHERE product_id = " + o[0]);
//			System.out.println("SELECT * from list_images WHERE product_id = " + o[0]);

			for (Object[] o1 : query1.getResultList()) {
				listimg.add((String) o1[1]);
			}
			p = new Product((int) o[0], (String) o[3], new Categories((int) o[7]), (String) o[2], listimg,
					(double) o[4], (boolean) o[1], (String) o[5], (int) o[6]);
		}
		return p;
	}

	@Override
	@Transactional
	public List<Product> getNewProduct(int page) {
		List<Product> list = new ArrayList<>();

		NativeQuery<Object[]> query = (NativeQuery<Object[]>) factory.getCurrentSession()
				.createNativeQuery("SELECT *\n" + "FROM products\n" + "ORDER BY product_id\n" + "OFFSET " + page
						+ " ROWS\n" + "FETCH NEXT 6 ROW ONLY;");

		for (Object[] o : query.getResultList()) {

			List<String> listimg = new ArrayList<String>();
			NativeQuery<Object[]> query1 = (NativeQuery<Object[]>) factory.getCurrentSession()
					.createNativeQuery("SELECT * from list_images WHERE product_id = " + o[0]);
			for (Object[] o1 : query1.getResultList()) {
				listimg.add((String) o1[1]);
			}
			list.add(new Product((int) o[0], (String) o[3], new Categories((int) o[7]), (String) o[2], listimg,
					(double) o[4], (boolean) o[1], (String) o[5], (int) o[6]));
		}
		return list;
	}

	@Override
	@Transactional
	public List<Product> getSaleProduct(int page) {
		List<Product> list = new ArrayList<>();

		NativeQuery<Object[]> query = (NativeQuery<Object[]>) factory.getCurrentSession().createNativeQuery("SELECT *\n"
				+ "FROM products\n" + "ORDER BY price\n" + "OFFSET " + page + " ROWS\n" + "FETCH NEXT 6 ROW ONLY;");

		for (Object[] o : query.getResultList()) {
			List<String> listimg = new ArrayList<String>();
			NativeQuery<Object[]> query1 = (NativeQuery<Object[]>) factory.getCurrentSession()
					.createNativeQuery("SELECT * from list_images WHERE product_id = " + o[0]);
//			System.out.println("SELECT * from list_images WHERE product_id = " + o[0]);

			for (Object[] o1 : query1.getResultList()) {
				listimg.add((String) o1[1]);
			}
			list.add(new Product((int) o[0], (String) o[3], new Categories((int) o[7]), (String) o[2], listimg,
					(double) o[4], (boolean) o[1], (String) o[5], (int) o[6]));
		}
		return list;
	}

	@Override
	@Transactional
	public List<Product> getProductTheoNhieuTieuChi(String tieuchi) {
		List<Product> list = new ArrayList<>();

		NativeQuery<Object[]> query = (NativeQuery<Object[]>) factory.getCurrentSession().createNativeQuery(
				"SELECT * FROM products WHERE\n"
				+ " product_id LIKE '%"+tieuchi+"%' or\n"
				+ "  motasp LIKE '%"+tieuchi+"%' or\n"
				+ "  nameProduct LIKE '%"+tieuchi+"%'\n"
				+ "  or price LIKE '%"+tieuchi+"%' or size  LIKE '%"+tieuchi+"%'");

		for (Object[] o : query.getResultList()) {
			List<String> listimg = new ArrayList<String>();
			NativeQuery<Object[]> query1 = (NativeQuery<Object[]>) factory.getCurrentSession()
					.createNativeQuery("SELECT * from list_images WHERE product_id = " + o[0]);
			for (Object[] o1 : query1.getResultList()) {
				listimg.add((String) o1[1]);
			}
			list.add(new Product((int) o[0], (String) o[3], new Categories((int) o[7]), (String) o[2], listimg,
					(double) o[4], (boolean) o[1], (String) o[5], (int) o[6]));
		}
		return list;
	}

}
