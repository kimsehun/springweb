package kr.co.mysqljava.user;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/selectUser")
	public String SelectUser(Model model) throws Exception
	{
		
		try {
			UserVO userVO = userService.selectUser();
			
			model.addAttribute("userVO", userVO);
			
			return "/user/selectUser";
			
		} catch (Exception e) {
			logger.info(e.toString());
			return "/error";
		}
	}
	
	@RequestMapping(value = "/selectUserList")
	public String SelectUserList(Model model) throws Exception
	{
		
		try {
			List<UserVO> list = userService.selectUserList();
			//for(int i =0; i < list.size(); i++)
			//	System.out.println(list.get(i));
				
			model.addAttribute("list", list);
			
			return "/user/selectUserList";
			
		} catch (Exception e) {
			logger.info(e.toString());
			return "/error";
		}
	}
	
	@RequestMapping(value = "/update/{uNumber}")
	public String userUpdate(@PathVariable int uNumber, Model model) throws Exception
	{
		
		try {
			UserVO userVO = userService.selectUser2(uNumber);
			logger.info(userVO.toString());
			model.addAttribute("userVO", userVO);
			return "/user/update";

		} catch (Exception e) {
			logger.info(e.toString());
			return "/error";
		}
	}
	
	@RequestMapping(value="/updateAction")
	public String updateAction(UserVO userVO, Model model)
	{
		try{
			
			userService.updateAction(userVO);
			
			model.addAttribute("msg", "성공");
			
		} catch (Exception e) {
			model.addAttribute("msg", "실패");
		}
		return "/user/update";

	}
	
}
