package study.spring.myschool.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.myschool.model.Student;
import study.spring.myschool.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.insert("StudentMapper.add_Student", student);
			if (result == 0) {
				throw new NullPointerException();

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new Exception("저장된 데이터가 없습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("데이터 저장에 실패했습니다.");
		}

	}

	@Override
	public void editStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.update("StudentMapper.edit_Student", student);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new Exception("변경된 데이터가 없습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("데이터 수정에 실패했습니다.");
		}

	}

	@Override
	public void deleteStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.delete("StudentMapper.delete_Student", student);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new Exception("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("데이터 삭제에 실패했습니다.");
		}

	}

	@Override
	public Student getStudentItem(Student student) throws Exception {
		// TODO Auto-generated method stub
		Student result = null;

		try {
			result = sqlSession.selectOne("StudentMapper.getStudent_Item", student);
			if (result == null) {
				throw new NullPointerException();
			}

		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<Student> getStudentList(Student student) throws Exception {
		// TODO Auto-generated method stub
		
		List<Student> result = null;
		
		try {
			result = sqlSession.selectList("StudentMapper.getStudent_List", student);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new Exception("조회된 목록이 없습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("데이터 목록 조회 결과를 실패했습니다.");
			
		}
		return result;
	}

	@Override
	public int getStudentCount(Student student) throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		try {
			result = sqlSession.selectOne("StudentMapper.selectStudentCount", student);
		
			
		}  catch (Exception e) {
			// TODO: handle exception
			throw new Exception("데이터 카운트에 실패했습니다.");
			
		} 
		return result;
	}

}
