import java.util.ArrayList;
import java.util.Scanner;

// Employee class to represent employee details
class Employee {
    private int id;          // Employee ID
    private String name;      // Employee Name
    private double salary;    // Employee Salary

    // Constructor to initialize employee details
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getter method for ID
    public int getId() {
        return id;
    }

    // Setter method for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for Name
    public String getName() {
        return name;
    }

    // Setter method for Name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for Salary
    public double getSalary() {
        return salary;
    }

    // Setter method for Salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Override toString() method to display employee details nicely
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>(); // ArrayList to store employees
    private static Scanner scanner = new Scanner(System.in);         // Scanner for user input

    public static void main(String[] args) {
        int choice;
        do {
            // Display the menu
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Process user's choice
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    displayAllEmployees();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0); // Continue until user chooses to exit

        scanner.close(); // Close the scanner to release resources
    }

    // Method to add a new employee
    private static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        employees.add(new Employee(id, name, salary)); // Add the new employee to the ArrayList
        System.out.println("Employee added successfully.");
    }

    // Method to update an existing employee's details
    private static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Employee employee : employees) { // Iterate through the ArrayList
            if (employee.getId() == id) { // Find the employee to update
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new salary: ");
                double salary = scanner.nextDouble();

                employee.setName(name);      // Update the employee's name
                employee.setSalary(salary);    // Update the employee's salary
                System.out.println("Employee details updated successfully.");
                return; // Exit the method after updating
            }
        }

        System.out.println("Employee not found."); // If employee not found
    }

    // Method to remove an employee
    private static void removeEmployee() {
        System.out.print("Enter employee ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < employees.size(); i++) { // Iterate through the ArrayList using index
            if (employees.get(i).getId() == id) { // Find the employee to remove
                employees.remove(i);              // Remove the employee
                System.out.println("Employee removed successfully.");
                return; // Exit the method after removing
            }
        }

        System.out.println("Employee not found."); // If employee not found
    }

    // Method to search for an employee
    private static void searchEmployee() {
        System.out.print("Enter employee ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Employee employee : employees) { // Iterate through the ArrayList
            if (employee.getId() == id) { // Find the employee
                System.out.println(employee); // Print the employee details
                return; // Exit the method after finding
            }
        }

        System.out.println("Employee not found."); // If employee not found
    }

    // Method to display all employees
    private static void displayAllEmployees() {
        if (employees.isEmpty()) { // Check if the ArrayList is empty
            System.out.println("No employees found.");
        } else {
            System.out.println("\nEmployee Details:");
            for (Employee employee : employees) { // Iterate through the ArrayList
                System.out.println(employee); // Print each employee's details
            }
        }
    }
}
