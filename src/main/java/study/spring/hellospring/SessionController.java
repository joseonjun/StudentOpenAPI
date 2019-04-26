package study.spring.hellospring;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

/** 컨트롤러 지정 */
@Controller
public class SessionController {
  /**
   * 세션 , 쿠키 저장을 위한 작성 페이지
   */

  @RequestMapping(value = "/session/write.do", method = RequestMethod.GET)
  public String home(Locale locale, Model model,
		  HttpServletRequest request, HttpServletResponse response) {
    /** 세션 값 처리 */
    HttpSession session = request.getSession();
    String mySession = (String) session.getAttribute("my_session");
    if (mySession == null) {
    	mySession = "";

    }
    /** 추출한 값을 view 에게 전달. */
    model.addAttribute("my_session_value", mySession);

    /** view 파일 지정  */
    return "session/write";

  }

  @RequestMapping(value = "/session/save.do", method = RequestMethod.POST)
  public String sessionSave(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response,
      @RequestParam(value = "memo", defaultValue = "") String memo) {
    // request 객체를 사용해서 세션 객체 만들기
    HttpSession session = request.getSession();
    if (memo.equals("")) {
      session.removeAttribute("my_session");
    } else {
      session.setAttribute("my_session", memo);
    }

    /** Spring방식의 페이지 이동  */
    // Servlet의 response.sendRedirect(url) 과 동일
    // 파일을 View로 지정한다.
    String url = "/session/write.do";
    return "redirect:" + url;

  }

}
