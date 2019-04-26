package study.spring.myschool.service;

import java.util.List;

import study.spring.myschool.model.Professor;

/** 교수 �?�? 기능?�� ?��공하�? ?��?�� Service 계층. */
public interface ProfessorService {
	
	/**
	 * 교수 ?��록하�?
	 * @param professor ???��?�� ?��보�?? ?���? ?��?�� Beans
	 * @throws Exception
	 */
	// --> import study.jsp.myschool.model.Professor;
	public void addProfessor(Professor professor) throws Exception;
	
	/**
	 * 교수 ?��?��?���?
	 * @param professor ?��?��?�� ?��보�?? ?���? ?��?�� Beans
	 * @throws Exception
	 */
	public void editProfessor(Professor professor) throws Exception;
	
	/**
	 * 교수 ?��?��?���?
	 * @param professor ?��?��?�� 교수?�� ?��?��번호�? ?���? ?��?�� Beans
	 * @throws Exception
	 */
	public void deleteProfessor(Professor professor) throws Exception;
	
	/**
	 * 교수 ?��?�� 조회
	 * @param professor 조회?�� 교수?�� ?��?��번호�? ?���? ?��?�� Beans
	 * @return 조회?�� ?��?��?���? ???��?�� Beans
	 * @throws Exception
	 */
	public Professor getProfessorItem(Professor professor) throws Exception;
	
	/**
	 * 교수 목록 조회
	 * @return 조회 결과?�� ???�� 컬렉?��
	 * @throws Exception
	 */
	// -> import java.util.List;
	public List<Professor> getProfessorList(Professor professor) throws Exception;
	
}
