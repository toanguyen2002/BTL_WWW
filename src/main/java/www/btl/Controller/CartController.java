package www.btl.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.btl.Entity.Product;
import www.btn.DAO.ProductDao;

@Controller
public class CartController {

	@Autowired
	ProductDao prodao;
	
	@RequestMapping("/cart")
	public String GioHang(Model model,HttpSession session) {
		HashMap<Integer, Integer> list = (HashMap<Integer, Integer>) session.getAttribute("listOrderDetail");
		List<www.btl.Entity.GioHang> gioHnag = new ArrayList<>();
		list.entrySet().forEach(x -> {
			Product p = prodao.getProductById(x.getKey());
			gioHnag.add(new www.btl.Entity.GioHang(p, x.getValue(), 0));
		});
		session.setAttribute("cart", gioHnag);
		return "trang-gio-hang";
	}
	@RequestMapping("/cart/remove")
	public String XoaGioHang(Model model,HttpSession session,@RequestParam("id") int id) {
		HashMap<Integer, Integer> list = (HashMap<Integer, Integer>) session.getAttribute("listOrderDetail");
		List<www.btl.Entity.GioHang> gioHnag = (List<www.btl.Entity.GioHang>) session.getAttribute("cart");
		list.remove(id);
		System.out.println(gioHnag.get(0).getProduct().getNameProduct());
		session.setAttribute("cart", gioHnag);
		
		
		return "redirect:/cart";
	}
}
