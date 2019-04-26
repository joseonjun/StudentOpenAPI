package study.spring.hellospring;

import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import study.spring.helper.PageHelper;
import study.spring.helper.WebHelper;
import study.spring.myschool.model.Department;

import study.spring.myschool.model.Student;
import study.spring.myschool.service.StudentService;

	/*컨트롤러 선언*/
@Controller
public class StudentController {
	

	Logger logger = LoggerFactory.getLogger(StudentController.class);
	

	
	@Autowired
	WebHelper web;
	
	@Autowired
	PageHelper page;
	
	@Autowired
	StudentService	studentService;
	
	/* 학생 목록 페이지 */
	@RequestMapping(value = "/student/stud_list.do", method = RequestMethod.GET)
	public ModelAndView StudList(Locale locale, Model model) {
		
		web.init();
		
		Student student = new Student();
		
		String keyword = web.getString("keyword", "");
		student.setName(keyword);
		
		
		int nowPage = web.getInt("page", 1);
		
		
		/* 페이지 번호 구현하기 */
		int totalCount = 0;
		
		
		try {
			totalCount = studentService.getStudentCount(student);
			
			System.out.println(totalCount);
			System.out.println(totalCount);
			System.out.println(totalCount);
			System.out.println(totalCount);
	
		} catch (Exception e) {
			// TODO: handle exception
			return web.redirect(null, e.getLocalizedMessage());
			
		}
		
		
		// 페이지 번호에 대한 연ㅅ나 수행 후 조회조건값 지정을 위한 Beans에 추가하기
		page.pageProcess(nowPage, totalCount, 10, 5);
		student.setLimitStart(page.getLimitStart());
		student.setListCount(page.getListCount());
		
		System.out.println(page.getLimitStart());
		System.out.println(page.getLimitStart());
		System.out.println(page.getListCount());
		System.out.println(page.getListCount());
		
		
		List<Student> list = null;
		
		try {
			list = studentService.getStudentList(student);
			
		} catch (Exception e) {
			// TODO: handle exception
			return web.redirect(null, e.getLocalizedMessage());

		}
		/* View 처리하기 */
		// 조회결과를 view에게 전달
		model.addAttribute("list",list);
		model.addAttribute("keyword", keyword);
		model.addAttribute("page", page);
		
		
		return new ModelAndView("student/stud_list");
		
	}
	
	
	
	/* 학생 상세 보기 */
	@RequestMapping(value = "/student/stud_view.do", method = RequestMethod.GET)
	public ModelAndView studView(Locale locale, Model model) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		
		int studno = web.getInt("studno");
		logger.debug("studno=" + studno);
		
		if (studno == 0) {
			return web.redirect(null, "학생번호가 없습니다.");
		}
		
		// 전달된 파라미터를 Beans에 저장한다.
		Student student = new Student();
		student.setStudno(studno);
		
		/** 2) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		Student item = null;
		try {
			item = studentService.getStudentItem(student);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		/** 3) View 처리하기 */
		model.addAttribute("item", item);
		
		return new ModelAndView("student/stud_view");
	}
	
	/** 학생 등록 페이지 */
	@RequestMapping(value = "/student/stud_add.do", method = RequestMethod.GET)
	public ModelAndView studAdd(Locale locale, Model model) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();

		/** 2) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		List<Student> deptList = null;
		try {
			deptList = studentService.getStudentList(null);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}

		/** 3) View 처리하기 */
		model.addAttribute("deptList", deptList);
		
		return new ModelAndView("student/stud_add");
	}
	
	/** 학생 등록 처리 페이지 (action 페이지로 사용된다.) */
	@RequestMapping(value = "/student/stud_add_ok.do", method = RequestMethod.POST)
	public ModelAndView studAddOk(Locale locale, Model model) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		
		// input 태그의 name속성에 명시된 값을 사용한다.
		String name = web.getString("name");
		String userid = web.getString("userid");
		int grade = web.getInt("grade");
		String idnum = web.getString("idnum");
		String birthdate = web.getString("birthdate");
		String tel = web.getString("tel");
		int deptno = web.getInt("deptno");
		int weight = web.getInt("weight");
		int height = web.getInt("height");
		int profno = web.getInt("profno");	
		
		
		/** 2) 필수항목에 대한 입력 여부 검사하기 */
		// RegexHelper를 사용하여 입력값의 형식을 검사할 수 도 있다. (여기서는 생략)
		logger.debug("name=" + name);
		logger.debug("userid=" + userid);
		logger.debug("grade=" + grade);
		logger.debug("idnum=" + idnum);
		logger.debug("birthdate=" + birthdate);
		logger.debug("tel=" + tel);
		logger.debug("deptno=" + deptno);
		logger.debug("profno=" + profno);
		logger.debug("weight=" + weight);
		logger.debug("height=" + height);
//		logger.debug("studno=" + studno);

		/** (3) 필수항목에 대한 입력 여부 검사하기 */
		if (name == null) {
			web.redirect(null, "이름을 입력하세요.");
			return null;
		}

		if (userid == null) {
			web.redirect(null, "아이디를 입력하세요.");
			return null;
		}

		if (grade == 0) {
			web.redirect(null, "학년을 입력하세요.");
			return null;
		}

		if (idnum == null) {
			web.redirect(null, "주민번호를 입력하세요.");
			return null;
		}

		if (birthdate == null) {
			web.redirect(null, "생년원일을 입력하세요.");
			return null;
		}

		if (tel == null) {
			web.redirect(null, "전화번호을(를) 입력하세요.");
			return null;
		}

		if (deptno == 0) {
			web.redirect(null, "학과번호를 입력하세요.");
			return null;
		}
		
		if (profno == 0) {
			web.redirect(null, "교수번호를 입력하세요.");
			return null;
		}
		
		/*
		 * if (studno == 0) { web.redirect(null, "학생번호가 존재하지 않습니다."); return null; }
		 */
		
		
		/** 3) 저장을 위한 JavaBeans 구성하기 */
		// --> study.jsp.myschool.model.student
		Student student = new Student();
		student.setName(name);
		student.setUserid(userid);
		student.setGrade(grade);
		student.setIdnum(idnum);
		student.setBirthdate(birthdate);
		student.setTel(tel);
		student.setWeight(weight);
		student.setHeight(height);
		student.setProfno(profno);
		student.setDeptno(deptno);
		
		
		/** 4) Service를 통한 SQL 수행 */
		try {
			studentService.addStudent(student);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		/** 5) 결과를 확인하기 위한 페이지로 이동하기 */
		String url = web.getRootPath() + "/student/stud_view.do?studno=" + student.getStudno();
		return web.redirect(url, "저장되었습니다.");
	}
	
	/** 학생 정보 삭제 페이지 */
	@RequestMapping(value = "/student/stud_delete.do", method = RequestMethod.GET)
	public ModelAndView studDelete(Locale locale, Model model) {

		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		
		int studno = web.getInt("studno");
		logger.debug("studno=" + studno);
		
		if (studno == 0) {
			return web.redirect(null, "학생번호가 없습니다.");
		}
		
		// 파라미터를 Beans에 저장한다.
		Student student = new Student();
		student.setStudno(studno);
		
		/** 2) Service를 통한 SQL 수행 */
		try {
			studentService.deleteStudent(student);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		/** 3) 목록페이지로 이동 */
		return web.redirect(web.getRootPath() + "/student/stud_list.do", "삭제되었습니다.");
	}
	
	/** 학생 정보 수정 페이지 */
	@RequestMapping(value = "/student/stud_edit.do", method = RequestMethod.GET)
	public ModelAndView studEdit(Locale locale, Model model) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		
		int studno = web.getInt("studno");
		logger.debug("studno=" + studno);
		
		if (studno == 0) { return web.redirect(null, "학생번호가 없습니다."); }

		// 파라미터를 Beans에 저장한다.
		Student student = new Student();
		student.setStudno(studno);
		
		/** 2) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		Student item = null;
		List<Department> deptList = null;
		try {
			item = studentJoinService.getstudentJoinItem(student);
			deptList = departmentService.getDepartmentList(null);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}

		/** 3) View 처리하기 */
		model.addAttribute("item", item);
		model.addAttribute("deptList", deptList);
		return new ModelAndView("student/stud_edit");
	}
	
	/** 학생 정보 수정 처리 페이지 (action 페이지로 사용된다) */
	@RequestMapping(value = "/student/stud_edit_ok.do", method = RequestMethod.POST)
	public ModelAndView studEditOk(Locale locale, Model model) {
		
		/** 1) WebHelper 초기화 및 파라미터 처리 */
		web.init();
		
		// input 태그의 name속성에 명시된 값을 사용한다.
				String name = web.getString("name");
				String userid = web.getString("userid");
				int grade = web.getInt("grade");
				String idnum = web.getString("idnum");
				String birthdate = web.getString("birthdate");
				String tel = web.getString("tel");
				int deptno = web.getInt("deptno");
				int weight = web.getInt("weight");
				int height = web.getInt("height");
				int profno = web.getInt("profno");	
				
				
				/** 2) 필수항목에 대한 입력 여부 검사하기 */
				// RegexHelper를 사용하여 입력값의 형식을 검사할 수 도 있다. (여기서는 생략)
				logger.debug("name=" + name);
				logger.debug("userid=" + userid);
				logger.debug("grade=" + grade);
				logger.debug("idnum=" + idnum);
				logger.debug("birthdate=" + birthdate);
				logger.debug("tel=" + tel);
				logger.debug("deptno=" + deptno);
				logger.debug("profno=" + profno);
				logger.debug("weight=" + weight);
				logger.debug("height=" + height);
//				logger.debug("studno=" + studno);

				/** (3) 필수항목에 대한 입력 여부 검사하기 */
				if (name == null) {
					web.redirect(null, "이름을 입력하세요.");
					return null;
				}

				if (userid == null) {
					web.redirect(null, "아이디를 입력하세요.");
					return null;
				}

				if (grade == 0) {
					web.redirect(null, "학년을 입력하세요.");
					return null;
				}

				if (idnum == null) {
					web.redirect(null, "주민번호를 입력하세요.");
					return null;
				}

				if (birthdate == null) {
					web.redirect(null, "생년원일을 입력하세요.");
					return null;
				}

				if (tel == null) {
					web.redirect(null, "전화번호을(를) 입력하세요.");
					return null;
				}

				if (deptno == 0) {
					web.redirect(null, "학과번호를 입력하세요.");
					return null;
				}
				
				if (profno == 0) {
					web.redirect(null, "교수번호를 입력하세요.");
					return null;
				}
				
				/*
				 * if (studno == 0) { web.redirect(null, "학생번호가 존재하지 않습니다."); return null; }
				 */
				
				
				/** 3) 저장을 위한 JavaBeans 구성하기 */
				// --> study.jsp.myschool.model.student
				Student student = new Student();
				student.setName(name);
				student.setUserid(userid);
				student.setGrade(grade);
				student.setIdnum(idnum);
				student.setBirthdate(birthdate);
				student.setTel(tel);
				student.setWeight(weight);
				student.setHeight(height);
				student.setProfno(profno);
				student.setDeptno(deptno);
		
		/** 4) Service를 통한 SQL 수행 */
		try {
			studentService.editStudent(student);
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		/** 5) 결과를 확인하기 위한 페이지로 이동하기 */
		String url = web.getRootPath() + "/student/stud_view.do?studno=" + student.getStudno();
		return web.redirect(url, "수정되었습니다.");
	
	}
}
