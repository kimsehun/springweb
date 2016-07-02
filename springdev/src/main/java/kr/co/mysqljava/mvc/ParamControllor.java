package kr.co.mysqljava.mvc;

import javax.validation.Valid;

import kr.co.mysqljava.mvc.MemoVO;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/param")
public class ParamControllor {

	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public void insert(){}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ModelAndView insertAction(@Valid MemoVO vo, BindingResult br){
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		
		if (br.hasErrors()) {	// not valid
			mav.setViewName("param/insert");
			return mav;
		} else {				// valid
			mav.setViewName("param/insertAction");
			return mav;
		}
	}
}
