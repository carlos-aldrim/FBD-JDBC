package schooljdbc;

import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		StudentManager studentManager = new StudentManager();
		Student student = new Student();
		Scanner entrada = new Scanner(System.in);
		int op;
		
		System.out.print("\t---------- MENU ----------\t\n");
		System.out.print("1 - INSERT\n");
		System.out.print("2 - SELECT\n");
		System.out.print("3 - UPDATE\n");
		System.out.print("4 - DELETE\n");
		
		do{
			System.out.print("Opção: ");
            op = entrada.nextInt();
            
			switch(op){
            case 1:
            	entrada.nextLine();
            	System.out.print("Digite o nome do estudante: ");
            	String nameNew = entrada.nextLine();
            	System.out.print("Digite o email do estudante: ");
            	String emailNew = entrada.next();
            	student.setName(nameNew);
        		student.setEmail(emailNew);
        		studentManager.addStudent(student);
                break;
                
            case 2:
            	for(Student s : studentManager.getStudents()) {
        			System.out.println("Id: " +s.getId()+ " | Nome: " +s.getName()+ " | Email: " +s.getEmail());
            	}
        		break;
                
            case 3:
            	System.out.print("Digite o código do estudante que deseja atualizar: ");
            	int idUpdate = entrada.nextInt();
            	entrada.nextLine();
            	System.out.print("Digite o nome do estudante: ");
            	String nameUpdate = entrada.nextLine();
            	System.out.print("Digite o email do estudante: ");
            	String emailUpdate = entrada.next();
            	student.setId(idUpdate);
            	student.setName(nameUpdate);
        		student.setEmail(emailUpdate);
        		studentManager.updateStudent(student);
                break;
                
            case 4:
            	System.out.print("Digite o código do estudante que deseja excluir: ");
            	int idDelete = entrada.nextInt();
            	student.setId(idDelete);
        		studentManager.deleteStudent(student);
                break;
            
            default:
                System.out.println("Sistema encerrado com sucesso!");
            }
        } while(op != 0);
	}
}
