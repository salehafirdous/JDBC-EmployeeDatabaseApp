package com.elevatelabs.tasks.task7;

import java.sql.*;
import java.util.Scanner;

public class EmployeeApp {

	
	private static final String URL = "jdbc:mysql://localhost:3306/employee_app"; 
	private static final String USER = "root";
	private static final String PASS = "saleha"; 

	private Connection getConnection() throws SQLException {
		
		
		return DriverManager.getConnection(URL, USER, PASS);
	}

	private void addEmployee(Scanner sc) {
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter department: ");
		String dept = sc.nextLine();
		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		sc.nextLine();

		String sql = "INSERT INTO employees(name, department, salary) VALUES(?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, name);
			ps.setString(2, dept);
			ps.setDouble(3, salary);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Employee added successfully.");
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}
	}

	private void viewEmployees() {
		String sql = "SELECT * FROM employees";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			System.out.println("Employee List...");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String dept = rs.getString("department");
				double salary = rs.getDouble("salary");
				System.out.println(id + " | " + name + " | " + dept + " | " + salary);
			}
		} catch (SQLException e) {
			
		}
	}

	private void updateEmployee(Scanner sc) {
		System.out.print("Enter Employee ID to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter new department: ");
		String dept = sc.nextLine();
		System.out.print("Enter new salary: ");
		double salary = sc.nextDouble();
		sc.nextLine();

		String sql = "UPDATE employees SET department=?, salary=? WHERE id=?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, dept);
			ps.setDouble(2, salary);
			ps.setInt(3, id);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Employee updated successfully.");
			} else {
				System.out.println("No employee found with ID " + id);
			}
		} catch (SQLException e) {
			
		}
	}

	private void deleteEmployee(Scanner sc) {
		System.out.print("Enter Employee ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();

		String sql = "DELETE FROM employees WHERE id=?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Employee deleted successfully!");
			} else {
				System.out.println("No employee found with ID " + id);
			}
		} catch (SQLException e) {
			
		}
	}

	private void menu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\nEmployee Database Menu..");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addEmployee(sc);
				break;
			case 2:
				viewEmployees();
				break;
			case 3:
				updateEmployee(sc);
				break;
			case 4:
				deleteEmployee(sc);
				break;
			case 5:
				System.out.println("Exit");
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	public static void main(String[] args) {
		new EmployeeApp().menu();
	}
}
