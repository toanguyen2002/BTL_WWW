package www.btn.DAO;

import java.util.List;

import www.btl.Entity.User;

public interface UserDao {
	public void saveUser(User user);
	public User findUserById(int id);
	public void deleteUser(int id);
	public User getUser(int id);
	public List<User> getAllUser();
	void updateUser(User user);
	public boolean isUserAdmin(String username, String password);
	public boolean isLogin(String username, String password);
	int getUserIdByUsernameAndPassword(String username, String password);
}
