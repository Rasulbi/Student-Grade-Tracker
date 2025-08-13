import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;
    String grade;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    // Calculate grade based on the student's own marks
    private String calculateGrade(double marks) {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== STUDENT GRADE TRACKER =====");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine(); // consume newline
            students.add(new Student(name, marks));
        }

        // Calculate highest and lowest marks
        double highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        for (Student s : students) {
            if (s.marks > highest) highest = s.marks;
            if (s.marks < lowest) lowest = s.marks;
        }

        // Print table header like in your image
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s%n",
                "Name", "Marks", "Grade", "Highest", "Lowest");
        System.out.println("--------------------------------------------------------");

        // Print each student's details
        for (Student s : students) {
            System.out.printf("%-15s %-10.2f %-10s %-10.2f %-10.2f%n",
                    s.name, s.marks, s.grade, highest, lowest);
        }

        sc.close();
    }
}
