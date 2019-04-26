package study.spring.myschool.service;

import java.util.List;

import study.spring.myschool.model.Department;

/** ?���? �?�? 기능?�� ?��공하�? ?��?�� Service 계층. */
public interface DepartmentService {
	/**
	 * ?���? 목록 조회
	 * @return 조회 결과?�� ???�� 컬렉?��
	 * @throws Exception
	 */
	// -> import java.util.List;
	public List<Department> getDepartmentList(Department professor) throws Exception;
}
