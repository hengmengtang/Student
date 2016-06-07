package view;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.getAllStudent;
import DTO.Student;

public class Students {
	static Scanner in=new Scanner(System.in);
	String ch;
	getAllStudent student=new getAllStudent();
	Student stu=new Student();
	ArrayList<Student> students=new ArrayList<>();
	
	public static String makeMenu()
    {
        System.out.println("");
        System.out.format("\t\t+--------------------------------------------------------------------------------------+%n");
        System.out.println("\t\t| 			*)Display | I)nsert | D)elete | U)pdate | S)earch|");
        System.out.println("\t\t|                                                                                      |");
        System.out.format("\t\t+--------------------------------------------------------------------------------------+%n");
        
        System.out.println("");
        System.out.println("Option: ");
        return in.nextLine().toLowerCase();
    }
	
	public void run() throws Exception
	{
        do
        {    	
        	ch=in.nextLine();
            switch(ch)
            {
                // display 
                case "*":
                {               	
                	students=student.getStudent(stu);
                	System.out.println(students.size());
                	for(int i=0;i<students.size();i++){
                		System.out.println(students);
                	}
                }
                break;
                // insert
                case "i":
                {           		
                	                	
                }
                break;
                // update
                case "u":
                {
                	
                }
                break;
                //delete
                case "d":
                {
                   
                }
                break;
                //search
                case "s":
                {
                   
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
		makeMenu();
	}
}
