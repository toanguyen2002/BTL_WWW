
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
		ss.setAttribute("userSecurity",false);
		ss.setAttribute("loginFailed", false);
		model.addAttribute("listSP", productDao.getAllProduct(0));
		model.addAttribute("numprd",0);


		return "Home";
	}
}	
