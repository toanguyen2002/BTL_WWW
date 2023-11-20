package www.btl.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table(name = "users")
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 3,message = "Tối thiểu 3 ký tự")
	@Size(max = 20,message = "Tối đa 20 ký tự")
//	@NotNull(message = "Không rỗng")
//	@Pattern(regexp = "[A-Za-z0-9]",message = "username Không có ký tự đặc biệt")
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String hoTen;
	private String sdt;
	public String role;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	public Set<Order> order;
	public User(int id, String username, String password, String hoTen, String sdt, String role, Set<Order> order) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.role = role;
		this.order = order;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Order> getOrder() {
		return order;
	}
	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", hoTen=" + hoTen + ", sdt="
				+ sdt + ", role=" + role + ", order=" + order + "]";
	}
	

	
}
