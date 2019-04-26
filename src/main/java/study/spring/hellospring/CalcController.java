package study.spring.hellospring;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.spring.hellospring.hello.Calc1;
import study.spring.hellospring.hello.Calc2;
import study.spring.hellospring.hello.Calc3;
import study.spring.hellospring.hello.Calc4;

@Controller
public class CalcController {

	@Autowired
	private Calc1 c1;
	@Autowired
	private Calc2 c2;
	@Autowired
	private Calc3 c3;
	@Autowired
	private Calc4 c4;

	@RequestMapping(value = "/calc.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		int value1 = c1.sum();
		int value2 = c2.sum();
		int value3 = c3.sum();
		int value4 = c4.sum();

		// 변수값을 View에게 전달한다.
		model.addAttribute("value1", value1);
		model.addAttribute("value2", value2);
		model.addAttribute("value3", value3);
		model.addAttribute("value4", value4);

		/* calc.jsp파일을 View로 지정한다. */
		return "calc";

	}

}
