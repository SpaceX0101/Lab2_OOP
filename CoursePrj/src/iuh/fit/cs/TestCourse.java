/**
 * @description: Test class for Course and CourseList with menu functionality
 * @author: Bui Nguyen Thanh Phi
 * @version: 1.0
 * @created: 28-Aug-2025 10:30:01 AM
 */

package iuh.fit.cs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCourse {
	private static CourseList courseList;
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
        try {
            System.out.print("Enter the maximum size of the course list: ");
            int maxSize = sc.nextInt();
            sc.nextLine(); 
            courseList = new CourseList(maxSize);
            
            System.out.print("Do you want to initialize sample data? (y/n): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                initData(courseList);
                System.out.println("Sample data has been successfully initialized!");
            }
            showMenu();
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Erorr: " + e.getMessage());
        } finally {
            sc.close();
        }
	}
	
	public static void initData(CourseList courseList) {
        try {
            courseList.addCourse(new Course("IT001", "Lap trinh can ban", 3, "Cong nghe thong tin"));
            courseList.addCourse(new Course("IT002", "Cau truc du lieu", 4, "Cong nghe thong tin"));
            courseList.addCourse(new Course("MA001", "Toan cao cap", 3, "Toan hoc"));
            courseList.addCourse(new Course("EN001", "Tieng Anh chuyen nganh", 2, "Ngoai ngu"));
            courseList.addCourse(new Course("IT003", "He dieu hanh", 4, "Cong nghe thong tin"));
        } catch (Exception e) {
            System.out.println("Data initialization error: " + e.getMessage());
        }
    }
	

	// Hien thi menu chinh va xu ly lua chon cua nguoi dung
    private static void showMenu() {
        int choice;
        do {
            System.out.println("\n=== COURSE MANAGEMENT MENU ===");
            System.out.println("1. Add a new course");
            System.out.println("2. Display course list");
            System.out.println("3. Remove a course");
            System.out.println("4. Find course by ID");
            System.out.println("5. Find courses by title");
            System.out.println("6. Find courses by department");
            System.out.println("7. Sort courses by title");
            System.out.println("8. Find course(s) with the highest credit");
            System.out.println("9. Find department with the most courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: addCourse(); break;
                case 2: displayCourses(); break;
                case 3: removeCourse(); break;
                case 4: findCourseById(); break;
                case 5: findCoursesByTitle(); break;
                case 6: findCoursesByDepartment(); break;
                case 7: sortCoursesByTitle(); break;
                case 8: findCoursesWithMaxCredit(); break;
                case 9: findDepartmentWithMostCourses(); break;
                case 0: System.out.println("Exiting program!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // Tim va hien thi khoa co nhieu khoa hoc nhat
    private static void findDepartmentWithMostCourses() {
        String department = courseList.findDepartmentWithMostCourses();
        if (department != null) {
            System.out.println("\nDepartment with the most courses: " + department);
        } else {
            System.out.println("The list is empty!");
        }
    }

    // Tim va hien thi cac khoa hoc co so tin chi lon nhat
    private static void findCoursesWithMaxCredit() {
        Course[] maxCreditCourses = courseList.findMaxCreditCourses();
        if (maxCreditCourses != null && maxCreditCourses.length > 0) {
            System.out.println("\n=== COURSE(S) WITH THE HIGHEST CREDIT ===");
            System.out.printf("%-10s %-30s %-8s %-20s\n", "ID", "Course Title", "Credits", "Department");
            System.out.println("-".repeat(70));
            for (Course course : maxCreditCourses) {
                System.out.println(course);
            }
        } else {
            System.out.println("The list is empty!");
        }
    }

    // Hien thi danh sach khoa hoc da duoc sap xep theo ten
    private static void sortCoursesByTitle() {
        Course[] sortedCourses = courseList.sortCourses();
        if (sortedCourses.length == 0) {
            System.out.println("The list is empty!");
            return;
        }
        System.out.println("\n=== COURSE LIST AFTER SORTING ===");
        System.out.printf("%-10s %-30s %-8s %-20s\n", "ID", "Course Title", "Credits", "Department");
        System.out.println("-".repeat(70));
        for (Course course : sortedCourses) {
            System.out.println(course);
        }
    }

    // Tim va hien thi cac khoa hoc theo ten khoa
    private static void findCoursesByDepartment() {
        System.out.print("Enter department name: ");
        String department = sc.nextLine();
        Course[] courses = courseList.searchCourseByDepartment(department);
        if (courses != null && courses.length > 0) {
            System.out.println("\n=== COURSES IN DEPARTMENT: " + department.toUpperCase() + " ===");
            System.out.printf("%-10s %-30s %-8s %-20s\n", "ID", "Course Title", "Credits", "Department");
            System.out.println("-".repeat(70));
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found for department: " + department);
        }
    }

    // Tim va hien thi cac khoa hoc theo ten khoa hoc
    private static void findCoursesByTitle() {
        System.out.print("Enter course title to search: ");
        String title = sc.nextLine();
        Course[] courses = courseList.searchCourse(title);
        if (courses != null && courses.length > 0) {
            System.out.println("\n=== SEARCH RESULTS ===");
            System.out.printf("%-10s %-30s %-8s %-20s\n", "ID", "Course Title", "Credits", "Department");
            System.out.println("-".repeat(70));
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found with a title containing: " + title);
        }
    }

    // Tim va hien thi mot khoa hoc theo ma (ID) chinh xac
    private static void findCourseById() {
        System.out.print("Enter course ID to find: ");
        String id = sc.nextLine();
        Course course = courseList.searchCourseById(id);
        if (course != null) {
            System.out.println("\n=== COURSE INFORMATION ===");
            System.out.printf("%-10s %-30s %-8s %-20s\n", "ID", "Course Title", "Credits", "Department");
            System.out.println("-".repeat(70));
            System.out.println(course);
        } else {
            System.out.println("No course found with ID: " + id);
        }
    }

    // Xoa mot khoa hoc khoi danh sach theo ma (ID)
    private static void removeCourse() {
        System.out.print("Enter ID of the course to remove: ");
        String id = sc.nextLine();
        if (courseList.removeCourse(id)) {
            System.out.println("Course removed successfully!");
        }
    }

    // Hien thi toan bo danh sach khoa hoc
    private static void displayCourses() {
        Course[] courses = courseList.getCourses();
        if (courses.length == 0) {
            System.out.println("The list is empty!");
            return;
        }
        System.out.println("\n=== COURSE LIST ===");
        System.out.printf("%-10s %-30s %-8s %-20s\n", "ID", "Course Title", "Credits", "Department");
        System.out.println("-".repeat(70));
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // Them mot khoa hoc moi vao danh sach
    private static void addCourse() {
        try {
            System.out.print("Enter course ID: ");
            String id = sc.nextLine();
            System.out.print("Enter course title: ");
            String title = sc.nextLine();
            System.out.print("Enter number of credits: ");
            int credit = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter responsible department: ");
            String department = sc.nextLine();

            Course course = new Course(id, title, credit, department);
            if (courseList.addCourse(course)) {
                System.out.println("Course added successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}