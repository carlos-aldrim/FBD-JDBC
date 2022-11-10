package schooljdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
	public void addStudent(Student student) {
		String sqlCommand = "INSERT INTO student (name, email) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sqlCommand);
			pstm.setString(1, student.getName());
			pstm.setString(2, student.getEmail());
			
			pstm.execute();
			System.out.println("-> Estudante salvo com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Student> getStudents() {
		String sqlCommand = "SELECT * FROM student";
		
		List<Student> students = new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sqlCommand);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Student student = new Student();
				
				student.setId(rset.getInt("id"));
				student.setName(rset.getString("name"));
				student.setEmail(rset.getString("email"));
				
				students.add(student);
			}
			
			int aux = students.size();
			if(aux == 0) {
				System.out.print("-> Não possui nenhum estudante no BD.\n");
			}
			else {
				System.out.print("-> Possui " + aux + " estudantes no BD.\n");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return students;
	}
	
	public void updateStudent(Student student) {
		String sqlCommand = "UPDATE student SET name = ? , email = ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sqlCommand);
			
			pstm.setString(1, student.getName());
			pstm.setString(2, student.getEmail());
			pstm.setInt(3, (int) student.getId());
			
			pstm.execute();
			System.out.print("-> Estudante atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteStudent(Student student) {
		String sqlCommand = "DELETE FROM student WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sqlCommand);
			pstm.setInt(1, (int) student.getId());
			
			pstm.execute();
			System.out.println("-> Estudante deletado com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
