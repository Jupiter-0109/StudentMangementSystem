import java.util.HashMap;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;
    private String course;
    private double grade;

    public Student(String id, String name, int age, String course, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.grade = grade;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public double getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
    public void setGrade(double grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age +
               ", Course: " + course + ", CGPA: " + grade;
    }
}



public class StudentManagementSystem {
    private static HashMap<String, Student> studentRecords = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: updateStudent(); break;
                case 3: removeStudent(); break;
                case 4: viewStudent(); break;
                case 5: viewAllStudents(); break;
                case 6: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        if (studentRecords.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();
        System.out.print("Enter CGPA: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); 

        studentRecords.put(id, new Student(id, name, age, course, grade));
        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        if (!studentRecords.containsKey(id)) {
            System.out.println("Student not found.");
            return;
        }

        Student student = studentRecords.get(id);

        System.out.print("Enter New Name (leave blank to keep unchanged): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) student.setName(name);

        System.out.print("Enter New Age (-1 to keep unchanged): ");
        int age = scanner.nextInt();
        if (age != -1) student.setAge(age);
        scanner.nextLine();

        System.out.print("Enter New Course (leave blank to keep unchanged): ");
        String course = scanner.nextLine();
        if (!course.isEmpty()) student.setCourse(course);

        System.out.print("Enter New CGPA (-1 to keep unchanged): ");
        double grade = scanner.nextDouble();
        if (grade != -1) student.setGrade(grade);
        scanner.nextLine(); 

        System.out.println("Student updated successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine();
        if (studentRecords.remove(id) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewStudent() {
        System.out.print("Enter Student ID to view: ");
        String id = scanner.nextLine();
        if (studentRecords.containsKey(id)) {
            System.out.println(studentRecords.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents() {
        if (studentRecords.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\nStudent List:");
            for (Student student : studentRecords.values()) {
                System.out.println(student);
            }
        }
    }
}
