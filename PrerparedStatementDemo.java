package com.ibm.training;
import java.util.Scanner;
import java.util.*;

import java.sql.*;


public class PrerparedStatementDemo {

	   static Connection dbCon;
	   PreparedStatement pstmt;
	public PrerparedStatementDemo() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibm20Jan?serverTimezone=UTC", "root", "");
			
		}
		 catch(SQLException e) {
			 System.out.println("Error during connecting : " + e.getMessage());
		 }
		
        
	}

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose from the below options :");
		System.out.println("Display the employee list - 1 ");
		System.out.println("Insert values into the table - 2");
		System.out.println("Update values in the table - 3");
		System.out.println("Delete values from the table - 4");
		int choice = scan.nextInt();
		switch(choice) {
		case 1:
	        new PrerparedStatementDemo().displayData(dbCon);
			break;
		case 2:
			new PrerparedStatementDemo().insertData(dbCon);	
			break;
		case 3:
			 new PrerparedStatementDemo().updateData(dbCon); 
			break;
		case 4:
			 new PrerparedStatementDemo().deleteData(dbCon);
			break;
		default:
			System.out.println("Not a valid option");	
		}
	}
	/*
	 * PreparedStatement stmt=con.prepareStatement("select * from emp"); ResultSet
	 * rs=stmt.executeQuery(); while(rs.next()){
	 * System.out.println(rs.getInt(1)+" "+rs.getString(2)); }
	 */


	
	
	 void displayData(Connection dbCon) {
		 try { 
			 pstmt = dbCon.prepareStatement("select * from employeeDetails");
			
			ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 
				System.out.println("Employee Name : " + rs.getString(1));
				System.out.print(" , Employee ID : " + rs.getInt(2));
				System.out.print(" , Employee designation : " + rs.getString(3));
				System.out.println(", Employee salary : " + rs.getInt(4));
				
				/* String name = rs.getString(1);
				 int id = rs.getInt(2);
				 String designation = rs.getString(3);
				 int salary = rs.getInt(4);
				 
				 System.out.println(name + id + designation + salary);*/
				 
			 }
			 dbCon.close();
			 
		 }catch(SQLException e) {
				 System.out.println("Exception during displaying the list " + e.getMessage());
			 }
		 }
	 
	
	 
	 
		 void updateData(Connection dbCon) {
				Scanner scan = new Scanner(System.in);
				String querySalary = "update employeedetails set Salary=? where ID=?";
				String queryName = "update employeedetails set Name=? where IDr=?";
				String queryDesignation = "update employeedetails set Designation=? where ID=?";
				String queryNumber = "update employeedetails set ID=? where ID=?";
				
				System.out.println("1 to update salary ");
				System.out.println("2 to update name");
				System.out.println("3 to update  desigantion");
				System.out.println("4 to update  number ");
				int n = scan.nextInt();
				scan.nextLine();
				switch(n) {
				case 1:
					try {
						pstmt = dbCon.prepareStatement(querySalary);
						System.out.println("Enter the new Salary");
						int salary = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter the employee ID to be changed");
						int id = scan.nextInt();
						scan.nextLine();
						pstmt.setInt(2,id);
						pstmt.setInt(1, salary);
						if(pstmt.executeUpdate()>0)
							System.out.println("Row updated");
						else
							System.out.println("Error while updating");
					} catch (SQLException e) {
						System.out.println("Exception while updating salary" + e.getMessage());
					}
					break;
				case 2:
					try {
						pstmt = dbCon.prepareStatement(queryName);
						System.out.println("Enter the new Name");
						String name = scan.nextLine();
						System.out.println("Enter the employee ID to be changed");
						int id = scan.nextInt();
						scan.nextLine();
						pstmt.setInt(2, id);
						pstmt.setString(1, name);
						if(pstmt.executeUpdate()>0)
							System.out.println("Row Updated");
						else
							System.out.println("Error while updating");
					} catch (SQLException e) {
						System.out.println("Exception while updating salary" + e.getMessage());
					}
					break;
				case 3:
					try {
						pstmt = dbCon.prepareStatement(queryDesignation);
						System.out.println("Enter the new Designation");
						String designation = scan.nextLine();
						System.out.println("Enter the employee ID to be changed");
						int id = scan.nextInt();
						scan.nextLine();
						pstmt.setInt(2, id);
						pstmt.setString(1, designation);
						if(pstmt.executeUpdate()>0)
							System.out.println("Row updated");
						else
							System.out.println("Error while updated");
					} catch (SQLException e) {
						System.out.println("Exception while updating designation" + e.getMessage());
					}
					break;
				case 4:
					try {
						pstmt = dbCon.prepareStatement(queryNumber);
						System.out.println("Enter the new IDr");
						int newID = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter the employee number to be changed");
						int number = scan.nextInt();
						scan.nextLine();
						pstmt.setInt(2, number);
						pstmt.setInt(1, newID);
						if(pstmt.executeUpdate()>0)
							System.out.println("Row Updated");
						else
							System.out.println("Error while updating");
					} catch (SQLException e) {
						System.out.println("Exception while updating number" + e.getMessage());
					}
					break;
				default:
					System.out.println("Not valid");
					break;
					
				}
			}
		 

  void deleteData(Connection dbCon) {
	  Scanner scan = new Scanner(System.in);
		String queryNumber = "delete from employeedetails where ID=?";
		String queryName = "delete from employeedetails where Name=?";
		String querySalary = "delete from employeedetails where Salary=?";
		String queryDesignation = "delete from employeedetails where Designation=?";
		
		System.out.println("1 to delete from employee number");
		System.out.println("2 to delete from employee name");
		System.out.println("3 to delete from employee salary");
		System.out.println("4 to delete from employee designation");
		int n= scan.nextInt();
		scan.nextLine();
		switch(n){
		case 1:
			try {
				pstmt = dbCon.prepareStatement(queryNumber);
				System.out.println("Enter the employee ID to be deleted");
				int id = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(1, id);
				if(pstmt.executeUpdate()>0)
					System.out.println("Row updated");
				else
					System.out.println("Not updated");
			} catch (SQLException e) {
				System.out.println("Error" + e.getMessage());
			}
			break;
			
		case 2:
			try {
				pstmt = dbCon.prepareStatement(queryName);
				System.out.println("Enter the employee name to be deleted");
				String name = scan.nextLine();
				pstmt.setString(1, name);
				if(pstmt.executeUpdate()>0)
					System.out.println("Row updated");
				else
					System.out.println("Not updated");
			} catch (SQLException e) {
				System.out.println("Error" + e.getMessage());
			}
			break;
			
		case 3:
			try {
				pstmt = dbCon.prepareStatement(querySalary);
				System.out.println("Enter the employee salary to be deleted");
				int salary = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(1, salary);
				if(pstmt.executeUpdate()>0)
					System.out.println("Row updated");
				else
					System.out.println("Not updated");
			} catch (SQLException e) {
				System.out.println("error" + e.getMessage());
			}
			break;
			
		case 4:
			try {
				pstmt = dbCon.prepareStatement(queryDesignation);
				System.out.println("Enter the employee designation to be deleted to be changed");
				String designation = scan.nextLine();
				pstmt.setString(1, designation);
				if(pstmt.executeUpdate()>0)
					System.out.println("Row updated");
				else
					System.out.println("Not updated");
			} catch (SQLException e) {
				System.out.println("Error" + e.getMessage());
			}
			break;
		default:
			System.out.println("Not valid");
			break;
		}
	}		

public void insertData(Connection dbCon) {
	Scanner scan = new Scanner(System.in);
	String query = "insert into employeedetails value(?,?,?,?)";
	try {
	System.out.println("Enter employee name");
	String name = scan.nextLine();
	System.out.println("Enter employee id");
	int id = scan.nextInt();
	scan.nextLine();
	System.out.println("Enter employee designation");
	String designation = scan.nextLine();
	System.out.println("Enter employee salary");
	int salary = scan.nextInt();
	scan.nextLine();
	pstmt = dbCon.prepareStatement(query);
	pstmt.setString(1,name);
	pstmt.setInt(2,id);
	pstmt.setString(3,designation);
	pstmt.setInt(4,salary);
	
	if(pstmt.executeUpdate()>0)
		System.out.println("Row inserted");
	else
		System.out.println("Row not inserted");
	} catch (SQLException e) {
		System.out.println("Exception while inserting " + e.getMessage());
	}
}
	
}















 
 