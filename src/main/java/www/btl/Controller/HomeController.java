
package www.btl.Controller;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import www.btl.Entity.Order;
import www.btl.Entity.OrderDetail;
import www.btl.Entity.Product;
import www.btl.Entity.User;
import www.btn.DAO.OrderDao;
import www.btn.DAO.ProductDao;


@Controller
public class HomeController {
	public boolean no = true;
	@Autowired
	public ProductDao productDao;
	@Autowired
	public OrderDao orderDao;
	
	@RequestMapping("/")
	public String getHome(Model model,HttpSession ss) {
//		ss.setAttribute("userSecurity",true);
//		ss.setAttribute("loginFailed", true);
//
		model.addAttribute("listSP", productDao.getAllProduct(0));
		model.addAttribute("numprd",0);
//		
//		
		Set<OrderDetail> od = new HashSet<OrderDetail>();
		Product p = productDao.getProductById(1);
		Product p1 = productDao.getProductById(2);
		Product p2 = productDao.getProductById(3);
//		System.out.println(p);
//		System.out.println(p1);
//		System.out.println(p2);
//
//		
//		
		

		
		
//		System.out.println(od);

		Order o =  new Order(LocalDate.now(), new User(1, null, null, null, null),null);
		OrderDetail oddt = new OrderDetail(p, o, 5,p.getPrice()*5);
		OrderDetail oddt1 = new OrderDetail(p1, o, 5,p1.getPrice()*5);
		OrderDetail oddt2 = new OrderDetail(p2, o, 5,p2.getPrice()*5);
		od.add(oddt);
		od.add(oddt1);
		od.add(oddt2);
		o.setOrdetail(od);
		System.out.println("o: "+o);
		orderDao.addOrder(o);

		return "Home";
	}
}	
