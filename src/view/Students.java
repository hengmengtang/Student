package view;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.getAllStudent;
import DTO.Student;

public class Students {
	static Scanner in=new Scanner(System.in);
	static String ch;
	static getAllStudent student=new getAllStudent();
	static Student stu=new Student();
	static ArrayList<Student> students=new ArrayList<>();
	
	public static String makeMenu()
    {
        System.out.println("");
        System.out.format("\t\t+--------------------------------------------------------------------------------------+%n");
        System.out.println("\t\t| 			*)Display | I)nsert | U)pdate | D)elete | S)earch| E)xit");
        System.out.println("\t\t|                                                                                      |");
        System.out.format("\t\t+--------------------------------------------------------------------------------------+%n");
        
        System.out.println("");
        System.out.println("Option: ");
        return in.nextLine().toLowerCase();
    }
	
	public static void run() throws Exception
	{
        do
        {    	
        		ch=makeMenu();
            switch(ch)
            {
                // display 
                case "*":
                {    
	                	students=student.getStudent(stu);       
	                	for (Student student : students) {
							System.out.println(student);
					}
                }
                break;
                // insert
                case "i":
                {           
                		System.out.println("ID: ");
                		stu.setId(in.nextInt());
                		in.nextLine();
                		System.out.println("Name: ");
                		stu.setName(in.nextLine());
                		System.out.println("Sex: ");
                		stu.setSex(in.nextLine());
                	     student.insertStudent(stu);        	
                }
                break;
                // update
                case "u":
                {
	                	System.out.println("ID: ");
	            		stu.setId(in.nextInt());
	            		in.nextLine();
	            		System.out.println("Name: ");
	            		stu.setName(in.nextLine());
	            		System.out.println("Sex: ");
	            		stu.setSex(in.nextLine());
                		student.updateStudent(stu);
                }
                break;
                //delete
                case "d":
                {
                		System.out.println("Remove By ID: ");
                		stu.setId(in.nextInt());
                		student.removeStudent(stu);
                }
                break;
                //search
                case "s":
                {
	                	System.out.println("Search By ID: ");
	            		stu.setId(in.nextInt());
	            		student.searchStudent(stu);
	            		System.out.println(stu.toString());
                }
                break;
                //exit
                case "e":
                {
                    System.exit(0);
                }
                break;
            }
            
        }while(!ch.equals("E"));
        
    }

	public static void main(String[] args){
		try {
			run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
