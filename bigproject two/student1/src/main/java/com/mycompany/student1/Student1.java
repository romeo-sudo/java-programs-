package com.mycompany.student1;
// imports are being added to make the methods to have to function  
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;

class Student1 {

    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student1(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }
     // function to search for student details 
    public static Student1 searchStudent(ArrayList<Student1> students, String targetId) {
        for (Student1 student : students) {
            if (student.getId().equals(targetId)) {
                return student;
            }
        }
        return null; // Student not found
    }
     // funxtion to display student details 
    public static void displayStudentReport(ArrayList<Student1> students) {
        StringBuilder report = new StringBuilder("Student Report:\n");

        for (int i = 0; i < students.size(); i++) {
            Student1 student = students.get(i);
            report.append("Student ").append(i + 1).append(":\n");
            report.append("ID: ").append(student.getId()).append("\n");
            report.append("Name: ").append(student.getName()).append("\n");
            report.append("Age: ").append(student.getAge()).append("\n");
            report.append("Email: ").append(student.getEmail()).append("\n");
            report.append("Course: ").append(student.getCourse()).append("\n\n");
        }

        if (students.isEmpty()) {
            report.append("No students found.\n");
        }

        JOptionPane.showMessageDialog(null, report.toString());
    }
    // function for capturing student details
    public static Student1 captureStudent() {

        String id = JOptionPane.showInputDialog("Enter student ID:");
        String name = JOptionPane.showInputDialog("Enter student name:");
        int age;
        String ageInput;

        do {
            ageInput = JOptionPane.showInputDialog("Enter student age:");
            try {
                age = Integer.parseInt(ageInput);
                if (age < 16) {
                    JOptionPane.showMessageDialog(null, "Invalid age. Please enter an age greater than or equal to 16.");
                }
            } catch (NumberFormatException e) {
                age = -1; // Set age to an invalid value to repeat the loop
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for age.");
            }
        } while (age < 16);

        String email = JOptionPane.showInputDialog("Enter student email:");
        String course = JOptionPane.showInputDialog("Enter student course:");

        // Create a new Student1 object with the captured details
        Student1 newStudent = new Student1(id, name, age, email, course);

        // Inform the user that the student details have been successfully saved
        JOptionPane.showMessageDialog(null, "Student details have been successfully saved.");

        return newStudent;
    }
  //methods run through this switch case and some are called as modules and some are coded insided the switch cases
    public static void main(String[] args) {
        // Set the color and style for the message box
        UIManager.put("OptionPane.background", Color.white);
        UIManager.put("Panel.background", Color.white);
        UIManager.put("OptionPane.messageForeground", Color.pink);
        UIManager.put("Button.background", Color.white);
        UIManager.put("Button.foreground", Color.pink);
       // an array is used to contain student details
        ArrayList<Student1> students = new ArrayList<>();

        while (true) {
            String[] options = {"Capture new student", "Search student", "Delete student", "Student report", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Select an option:",
                    "Student Management System",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    Student1 newStudent = captureStudent();
                    students.add(newStudent);
                    JOptionPane.showMessageDialog(null, "Student details saved.");
                    break;
                case 1:
                    String searchId = JOptionPane.showInputDialog("Enter student ID to search:");
                    Student1 foundStudent = Student1.searchStudent(students, searchId);
                    if (foundStudent != null) {
                        // Student found, display details
                        String studentDetails = "ID: " + foundStudent.getId() + "\nName: " + foundStudent.getName()
                                + "\nAge: " + foundStudent.getAge() + "\nEmail: " + foundStudent.getEmail()
                                + "\nCourse: " + foundStudent.getCourse();
                        JOptionPane.showMessageDialog(null, "Student Details:\n" + studentDetails);
                    } else {
                        // Student not found, display error message
                        JOptionPane.showMessageDialog(null, "Student not found.");
                    }
                    break;
                case 2:

                    String deleteId = JOptionPane.showInputDialog("Enter student ID to delete:");
                    Student1 studentToDelete = Student1.searchStudent(students, deleteId);
                    if (studentToDelete != null) {
                        int confirmDelete = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?\nID: " + studentToDelete.getId() + "\nName: " + studentToDelete.getName(), "Confirm Delete", JOptionPane.YES_NO_OPTION);
                        if (confirmDelete == JOptionPane.YES_OPTION) {
                            students.remove(studentToDelete);
                            JOptionPane.showMessageDialog(null, "Student deleted successfully.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found.");
                    }
                    break;

                case 3:
                    displayStudentReport(students); // Display student report

                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Exiting the application.");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid option.");
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

}
