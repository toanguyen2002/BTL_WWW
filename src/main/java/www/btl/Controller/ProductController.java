package www.btl.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import www.btl.Entity.Categories;
import www.btl.Entity.OrderDetail;
import www.btl.Entity.Product;
import www.btn.DAO.ProductDao;

@Controller
public class ProductController {
	@Autowired
	public ProductDao productDao;

	@RequestMapping("/danhsachsanpham")
	public String getDanhSachSanPham(Model model, @RequestParam("num") int num, @RequestParam("gt") String gt,
			HttpSession ss) {
		List<Product> listsp = new ArrayList<Product>();
		String titlesp = "";
		if (gt.equals("all")) {
			titlesp = "Tất Cả Sản Phẩm";
			listsp = productDao.getAllProduct(num);
		}
		if (gt.equals("new")) {
			titlesp = "Sản Phẩm Mới";
			listsp = productDao.getNewProduct(num);
		}
		if (gt.equals("sale")) {
			titlesp = "Sản Phẩm Đang Được Sale";
			listsp = productDao.getSaleProduct(num);
		}
		model.addAttribute("listSP", listsp);
		model.addAttribute("title", titlesp);
		model.addAttribute("gtsp", gt);
		model.addAttribute("numprd", num);
		
		return "danh-sach-san-pham";
	}

	@RequestMapping("/danhsachsanphamPT")
	public String getDanhSachSanPhamPhanTrang(Model model, @RequestParam("num") int num, @RequestParam("gt") String gt,
			HttpSession ss) {
		List<Product> listsp = new ArrayList<Product>();
		String titlesp = "";
		if (gt.equals("all")) {
			titlesp = "Tất Cả Sản Phẩm";
			listsp = productDao.getAllProduct(num);
		}
		if (gt.equals("new")) {
			titlesp = "Sản Phẩm Mới";
			listsp = productDao.getNewProduct(num);
		}
		if (gt.equals("sale")) {
			titlesp = "Sản Phẩm Đang Được Sale";
			listsp = productDao.getSaleProduct(num);
		}
		model.addAttribute("listSP", listsp);
		model.addAttribute("title", titlesp);
		model.addAttribute("gtsp", gt);
		model.addAttribute("numprd", num);
		return "redirect:/danhsachsanpham?num=" + num + "&gt=" + gt;
	}

	@RequestMapping("/productController")
	public String quanLySanPham(Model model, @RequestParam("num") int num, HttpSession ss) {
		model.addAttribute("allsp", productDao.getAllProduct(num));
		System.out.println(productDao.getAllProduct(num));
		boolean sss = (boolean) ss.getAttribute("userSecurity");
		return "quan-li-san-pham";
	}

	@RequestMapping("/product")
	public String xemChiTietSanPham(Model modell, @RequestParam("id") int id) {
		System.out.println(productDao.getProductById(id));
		modell.addAttribute("product", productDao.getProductById(id));
		return "chi-tiet-san-pham";
	}

	@RequestMapping("/addForm")
	public String goFormThemsp(Model modell, @Valid @ModelAttribute("product") Product product, BindingResult rs) {
		List<Categories> ls = new ArrayList<Categories>();
		ls.add(new Categories(1, "boy", null));
		ls.add(new Categories(2, "girl", null));
		ls.add(new Categories(3, "all", null));
		modell.addAttribute("cate", ls);
		return "them-san-pham";
	}
	@RequestMapping("/updateform")
	public ModelAndView goFormupdatesp(Model nodel,@RequestParam("id") int id) {
		System.out.println(productDao.getProductById(id));
		List<Categories> ls = new ArrayList<Categories>();
		ls.add(new Categories(1, "boy", null));
		ls.add(new Categories(2, "girl", null));
		ls.add(new Categories(3, "all", null));
		nodel.addAttribute("cate", ls);
		return new ModelAndView("update-san-pham","product",productDao.getProductById(id));
	}
	@RequestMapping("/updateform/update")
	public ModelAndView updatesp(@ModelAttribute("product") Product product
			,@RequestParam("anhsp") List<CommonsMultipartFile> multipartFile
			,HttpSession session,@RequestParam("cateid") int id
			,@RequestParam("instock") boolean stock) throws IOException {
		
		Product p = productDao.getProductById(product.getIdProduct());
		
		System.out.println("chauw update: "+p);
		if (p.getListImage().size() > 0) {
			p.getListImage().clear();
		}
		ServletContext context = session.getServletContext();
		List<String> arr = new ArrayList<String>();
		for (CommonsMultipartFile commonsMultipartFile : multipartFile) {
			BufferedOutputStream fou = new BufferedOutputStream(new FileOutputStream(new File(context.getRealPath("/WEB-INF/assets") + File.separator + commonsMultipartFile.getOriginalFilename())));
			fou.write(commonsMultipartFile.getBytes());
			fou.flush();
			fou.close();
			arr.add(commonsMultipartFile.getOriginalFilename());
		}
		p.setMotasp(product.getMotasp());
		p.setNameProduct(product.getNameProduct());
		p.setPrice(product.getPrice());
		p.setCategories(new Categories(id));
		p.setListImage(arr);
		p.setInStock(stock);
		p.setSize(product.getSize());
		p.setSoluong(product.getSoluong());
		System.out.println(p);
		productDao.update(p);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/addForm/add")
	public String Themsp(Model modell, @Valid @ModelAttribute("product") Product product, 
			BindingResult rs,
			@RequestParam("anhsp") List<CommonsMultipartFile> file,
			HttpSession session,@RequestParam("cateid") int id) throws IOException {
		if (rs.hasErrors()) {
			return "them-san-pham";
		}
		ArrayList<String> arr = new ArrayList<String>();
		ServletContext context = session.getServletContext();
		System.out.println(file.get(0).getOriginalFilename());
		for (CommonsMultipartFile commonsMultipartFile : file) {
			System.out.println(commonsMultipartFile);
			BufferedOutputStream fou = new BufferedOutputStream(new FileOutputStream(new File(context.getRealPath("/WEB-INF/assets") + File.separator + commonsMultipartFile.getOriginalFilename())));
			fou.write(commonsMultipartFile.getBytes());
			fou.flush();
			fou.close();
			arr.add(commonsMultipartFile.getOriginalFilename());
		}
		product.setCategories(new Categories(id));
		product.setListImage(arr);
		product.setInStock(true);
		productDao.save(product);
		return "redirect:/";
	}

//	dsquanlisanpham?soTrang=2 &gt=${gtsp}
	@RequestMapping("/dsquanlisanpham")
	public String getQLsanPhamPT(@RequestParam("num") int sotrang,HttpSession session) {
		HashMap<Integer, Integer> list = (HashMap<Integer, Integer>) session.getAttribute("listOrderDetail");
		System.out.println("list: "+list);
		productDao.getAllProduct(sotrang);
		return "redirect:/productController?num=" + sotrang;
	}
	///addCart?id=${sp.getIdProduct()}
	@RequestMapping("/addCart")
	public String addCart(HttpSession session,@RequestParam("id") int idproduct,@RequestParam("quantity") int num) {
		HashMap<Integer, Integer> list = (HashMap<Integer, Integer>) session.getAttribute("listOrderDetail");
		if (list == null) {
		    list = new HashMap<Integer, Integer>();
		}
		if (list.containsKey(idproduct)) {
		    list.put(idproduct, list.get(idproduct) + num);
		}else {
			 list.put(idproduct, num);
		}

		session.setAttribute("listOrderDetail", list);
;
		return "redirect:/";
	}
	@RequestMapping("/addCart1")
	public String addCart1(HttpSession session,@RequestParam("id") int idproduct,@RequestParam("quantity") int num) {
		HashMap<Integer, Integer> list = (HashMap<Integer, Integer>) session.getAttribute("listOrderDetail");
		if (list == null) {
		    list = new HashMap<Integer, Integer>();
		}
		if (list.containsKey(idproduct)) {
		    list.put(idproduct, list.get(idproduct) + num);
		}else {
			 list.put(idproduct, num);
		}

		session.setAttribute("listOrderDetail", list);
		
		return "redirect:/danhsachsanpham?num=0&gt=all";
	}
}
