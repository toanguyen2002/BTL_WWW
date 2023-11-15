package www.btn.DAO;

import java.util.List;

import www.btl.Entity.User;

public interface UserDao {
	public void saveUser(User user);
	public User findUserById(int id);
	public boolean deleteUser(int id);
	public boolean updateUser(User user);
	public List<User>  getAllUser();
}
