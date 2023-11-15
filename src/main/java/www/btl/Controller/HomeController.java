
package www.btl.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import www.btn.DAO.ProductDao;


@Controller
public class HomeController {
	public boolean no = true;
	@Autowired
	public ProductDao productDao;
	
	@RequestMapping("/")
	public String getHome(Model model,HttpSession ss) {
		ss.setAttribute("userSecurity",true);
		ss.setAttribute("loginFailed", true);

		model.addAttribute("listSP", productDao.getAllProduct(0));
		model.addAttribute("numprd",0);
		return "Home";
	}
}	
