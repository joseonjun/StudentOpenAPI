package study.spring.myschool.service;

import java.util.List;

import study.spring.myschool.model.Student;

public interface StudentService {

	/**
	 * 학생 ?��록하�?
	 * @param Student ???��?�� ?��보�?? ?���? ?��?�� Beans
	 * @throws Exception
	 */
	// --> import study.jsp.myschool.model.Student;
	public void addStudent(Student student) throws Exception;
	
	/**
	 * 학생 ?��?��?���?
	 * @param Student ?��?��?�� ?��보�?? ?���? ?��?�� Beans
	 * @throws Exception
	 */
	public void editStudent(Student student) throws Exception;
	
	/**
	 * 학생 ?��?��?���?
	 * @param Student ?��?��?�� 학생?�� ?��?��번호�? ?���? ?��?�� Beans
	 * @throws Exception
	 */
	public void deleteStudent(Student student) throws Exception;
	
	/**
	 * 학생 ?��?�� 조회
	 * @param Student 조회?�� 학생?�� ?��?��번호�? ?���? ?��?�� Beans
	 * @return 조회?�� ?��?��?���? ???��?�� Beans
	 * @throws Exception
	 */
	public Student getStudentItem(Student student) throws Exception;
	
	/**
	 * 학생 목록 조회
	 * @return 조회 결과?�� ???�� 컬렉?��
	 * @throws Exception
	 */
	// -> import java.util.List;
	public List<Student> getStudentList(Student student) throws Exception;
	
	
	/**
	 * 학생 전체 수 카운트
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int getStudentCount(Student student) throws Exception ;
	
}
