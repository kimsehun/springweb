package kr.co.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class test {

	@RequestMapping(value = "/test2", method=RequestMethod.GET)
	public void regist() {}
	
}
