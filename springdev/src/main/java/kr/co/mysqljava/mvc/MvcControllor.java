package kr.co.mysqljava.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mvc")
public class MvcControllor {
	
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		System.out.println("test");
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("msg", "Hello @MV2C");
		mvc.setViewName("hello");
		//return new ModelAndView("hello","msg","Hello @MVC");
		return mvc;
	}
	
	@RequestMapping("/source")
	public void source() {}

	@RequestMapping("/target")
	public void target(String name, int age, Model model) {
		model.addAttribute("iam", "그래, 난 " + age + "세 " + name + ".");
	}
	
	@RequestMapping("/{dong}")
	public String dong(@PathVariable String dong, Model model) {
		model.addAttribute("jumin", dong + " 주민입니다.");
		return "mvc/dong";
	}
	
	@RequestMapping("/target/{name}/{age}")
	public String target2(
		@PathVariable String name, @PathVariable int age, Model model) {
		
		model.addAttribute("iam", "그래, 난 " + age + "세 " + name + ".");
		return "mvc/target";
	}
}
