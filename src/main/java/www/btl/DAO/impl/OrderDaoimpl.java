package www.btl.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import www.btl.Entity.Order;
import www.btn.DAO.OrderDao;

@Repository
@Transactional
public class OrderDaoimpl implements OrderDao {

    @Autowired
    public SessionFactory factory;

    @Override
    public void addOrder(Order order) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public void updateOrder(Order order) {
        Session session = factory.getCurrentSession();
        session.update(order);
    }

    @Override
    public List<Order> getAllOrderByUserID(int userID) {
        Session session = factory.getCurrentSession();
        return session.createQuery("FROM Order WHERE user_id = :userId", Order.class)
                .setParameter("userId", userID)
                .getResultList();
    }

    @Override
    public Order getOrderByID(int orderID) {
        Session session = factory.getCurrentSession();
        return session.get(Order.class, orderID);
    }
    // không có chức năng delete
    /*@Override
    public boolean deleteOrder(int orderID) {
        Session session = factory.getCurrentSession();
        Order order = session.get(Order.class, orderID);
        if (order != null) {
            session.delete(order);
            return true;
        }
        return false;
    }
*/
    @Override
    public boolean editOrder(Order order) {
        try {
            updateOrder(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		return session.createQuery("FROM Order", Order.class).getResultList();
	}
}
