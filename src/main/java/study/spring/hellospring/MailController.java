package study.spring.hellospring;

import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import study.spring.helper.MailHelper;
import study.spring.helper.RegexHelper;
import study.spring.helper.WebHelper;

@Controller
public class MailController {

	/** 객체 주입 설정 */
	@Autowired
	WebHelper web;

	@Autowired
	RegexHelper regex;

	@Autowired
	MailHelper mail;

	/** 메일 작성 폼을 구현하기 위한 컨트롤러 */
	@RequestMapping(value = "/mail/write.do", method = RequestMethod.GET)

	public ModelAndView write(Locale locale, Model model) {
		web.init();

		return new ModelAndView("mail/write");

	}

	/** 메일 발송처리를 구현할 컨트롤러 */
	@RequestMapping(value = "/mail/mail_ok.do", method = RequestMethod.POST)
	public ModelAndView mailOK(Locale locale, Model model) {
		web.init();

		/** 파라미터 받기 */
		String sender = web.getString("sender");
		String receiver = web.getString("receiver");
		String subject = web.getString("subject");
		String content = web.getString("content");

		// 입력여부 검사후, 입력되지 않ㅇ느 경우 이전 페이지로 보내기
		if (!regex.isEmail(sender)) {
			return web.redirect(null, "보내는 사람의 주소가 맞지 않습니다.");
		}
		if (!regex.isEmail(receiver)) {
			return web.redirect(null, "받는 사람의 주소가 맞지 않습니다.");
		}
		if (!regex.isValue(subject)) {
			return web.redirect(null, "메일 제목을 입력하세요.");
		}
		if (!regex.isValue(sender)) {
			return web.redirect(null, "메일의 내용을 입력하세요.");
		}

		/* 메일 발송처리 */
		try {
			mail.sendMail(sender, receiver, subject, content);
		} catch (MessagingException e) {
			// TODO: handle exception
			return web.redirect("write.do", e.getLocalizedMessage());
		}

		return web.redirect("write.do", "메일이 발송되었습니다.");

	}
}
