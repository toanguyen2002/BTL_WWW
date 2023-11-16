package www.btl.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import www.btl.Entity.Order;
import www.btn.DAO.OrderDao;

public class OrderDaoimpl implements OrderDao{
	@Autowired
	public SessionFactory factory;

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getAllOrderByUserID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderByID(int orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOrder(int orderID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

}
