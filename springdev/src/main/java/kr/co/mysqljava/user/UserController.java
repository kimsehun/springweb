package kr.co.mysqljava.user;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
			
	@RequestMapping(value = "/regist", method=RequestMethod.GET)
	public void regist() {}

	

	@RequestMapping(value = "/regist", method=RequestMethod.POST)
	public String registAction(UserVO userVO,Model model) throws Exception {
		
		//logger.info(userVO.toString());
		
		model.addAttribute("userVO", userVO);
		
		try {
			userService.registUser(userVO);
			return "/user/registAction";
		} catch (Exception e) {
			logger.info(e.toString());
			//throw new RuntimeException();
			return "/user/regist";
		}
	}
}
