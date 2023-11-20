package www.btn.DAO;

import java.util.List;

import www.btl.Entity.Product;

public interface ProductDao {
	public Product getProductById(int id);
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public List<Product> getAllProduct(int page); 
	public List<Product> getNewProduct(int page); 
	public List<Product> getSaleProduct(int page); 
	public List<Product> getProductTheoNhieuTieuChi(String tieuchi); 
}
