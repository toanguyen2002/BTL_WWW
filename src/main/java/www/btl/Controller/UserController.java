package www.btl.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/userController")
	public String getUserController() {
		return "danh-sach-khach-hang";
	}
}
