/**
 * @description: This class manages a list of courses
 * @author: Bui Nguyen Thanh Phi
 * @version: 1.0
 * @created: 28-Aug-2025 10:29:40 AM
 */

package iuh.fit.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CourseList {
	private Course[] courses;
	private int n;
	
	public CourseList(int maxSize) {
		if(maxSize <= 0) {
			throw new IllegalArgumentException("Length of the array must be greater than 0");
		}
		this.courses = new Course[maxSize];
		this.n = 0;
	}
	
	// Them khoa hoc:
	public boolean addCourse(Course course) {
		if(n >= courses.length) {
			System.out.println("Full list !");
			return false;
		}
		if (exists(course)) {
            System.out.println("Error: The course code already exists !");
            return false;
        }
		courses[n++] = course;
		return true;
	}
	
	public Course[] getCourses() {
		return Arrays.copyOf(courses, n);
	}
	// Xoa khoa hoc theo ID:
	public boolean removeCourse(String id) {
		for(int i = 0; i < n; i++) {
			if(courses[i].getId().equals(id)) {
				for(int j = i; j < n - 1; j++) {
					courses[j] = courses[j + 1];
				}
				n--;
				courses[n] = null;
				return true;
			}
		}
		System.out.println("Error: Course with the code not found " + id);
		return false;
	}
	// Tim khoa hoc theo ID:
	public Course searchCourseById(String id) {
		for(int i = 0; i < n; i++) {
			if(courses[i].getId().equals(id)) {
				return courses[i];
			}
		}
		return null;
	}
	// Tim khoa hoc theo ten (tim tuong doi):
	public Course[] searchCourse(String title) {
		List<Course> result = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
				result.add(courses[i]);
			}
		}
		return result.isEmpty() ? null : result.toArray(new Course[0]);
	}
	// Tim khoa hoc theo khoa:
	public Course[] searchCourseByDepartment(String department) {
		List<Course> result = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(courses[i].getDepartment().equals(department)) {
				result.add(courses[i]);
			}
		}
		return result.isEmpty() ? null : result.toArray(new Course[0]);
	}
	// Sap xep theo ten (khong thay doi danh sach):
	public Course[] sortCourses() {
		Course[] sortedCourses = Arrays.copyOf(courses, n);
		Arrays.sort(sortedCourses, (c1, c2) -> c1.getTitle().compareTo(c2.getTitle()));
		return sortedCourses;
	}
	// Tim khoa hoc co so tin chi lon nhat:
	public Course[] findMaxCreditCourses() {
		if(n == 0) return null;
		int maxCredit = 0;
		for(int i = 0; i < n; i++) {
			if(courses[i].getCredit() > maxCredit) {
				maxCredit = courses[i].getCredit();
			}
		}
		List<Course> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (courses[i].getCredit() == maxCredit) {
                result.add(courses[i]);
            }
        }
        
        return result.toArray(new Course[0]);
	}
	// Tim khoa co khoa hoc nhieu nhat:
	public String findDepartmentWithMostCourses() {
		if(n == 0) return null;
		// Dem so khoa hoc cua moi khoa:
		String[] departments = new String[n];
        int[] counts = new int[n];
        int numDepts = 0;
        
        for (int i = 0; i < n; i++) {
            String dept = courses[i].getDepartment();
            boolean found = false;
            
            for (int j = 0; j < numDepts; j++) {
                if (departments[j].equals(dept)) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                departments[numDepts] = dept;
                counts[numDepts] = 1;
                numDepts++;
            }
        }
        // Tim khoa co nhieu khoa hoc nhat:
        int maxCount = 0;
        String result = null;
        for (int i = 0; i < numDepts; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                result = departments[i];
            }
        }
        return result;
	}
	public int getSize() {
        return n;
    }
	// Kiem tra khoa hoc co ton tai khong
	public boolean exists(Course course) {
        for (int i = 0; i < n; i++) {
            if (courses[i].getId().equals(course.getId())) {
                return true;
            }
        }
        return false;
    }
}
	

