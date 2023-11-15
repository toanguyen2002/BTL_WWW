package www.btl.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.btl.Entity.User;
import www.btn.DAO.UserDao;

@Repository
public class UserDaoimpl implements UserDao{
	
	@Autowired
	public SessionFactory factory;

	@Override
	public void saveUser(User user) {
		NativeQuery<Object[]> query = factory.getCurrentSession().createNativeQuery("");
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
