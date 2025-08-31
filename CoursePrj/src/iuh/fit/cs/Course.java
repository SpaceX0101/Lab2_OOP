/**
 * @description: This class represents a course with id, title, credit and department
 * @author: Bui Nguyen Thanh Phi
 * @version: 1.0
 * @created: 28-Aug-2025 10:29:12 AM
 */

package iuh.fit.cs;

public class Course {
	private int credit;
	private String department;
	private String id;
	private String title;
	
	public Course() {

	}

	public Course(String id, String title, int credit, String department) {
		setId(id);
		setTitle(title);
		setCredit(credit);
		this.department = department;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		if(credit <= 0) {
			throw new IllegalArgumentException("Credit must be greater than 0");
		}
		this.credit = credit;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(id == null || id.length() < 3 || !id.matches("[A-Za-z0-9]+")) {
			throw new IllegalArgumentException("ID must have at least 3 characters and contain only letters or digits");
		}
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException("Title must not be empty");
		}
		this.title = title;
	}
	
	public String toString() {
		return String.format("%-8s %-30s %-6s %-20s", id, title, credit, department);
	}
}

