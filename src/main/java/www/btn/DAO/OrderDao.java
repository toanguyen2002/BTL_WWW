package www.btn.DAO;

import java.util.List;

import www.btl.Entity.Order;

public interface OrderDao {
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public List<Order> getAllOrderByUserID(int userID);
	public Order getOrderByID(int orderID);
	public boolean deleteOrder(int orderID);
	public boolean editOrder(Order order);
}
