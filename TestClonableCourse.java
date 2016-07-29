/** Program: Test Clonable Course 
 *  File:    TestClonableCourse.java
 *  Summary: Week6 Exercise 13.13 
 *           Using Ron's Code for the course Class, implement Cloneable for the Course Class. The main class tests the effectiveness of the clone() method and prints 
 *           the variable values for the original course and the cloned course. 
 *  Author:  Lee Tompkins 
 *  Date:    July 29 2016
 **/
public class TestClonableCourse {

	public static void main(String[] args) throws CloneNotSupportedException {
		Course course1 = new Course("Cloning Course"); // Construct Course Object with given parameters 
		// Add students to the course 
		course1.addStudent("Ron");
		course1.addStudent("Lee");
		course1.addStudent("Eric");
		Course clonedCourse = (Course)course1.clone(); // Clone original course 
		// Print data field values for original and cloned course objects 
		System.out.println("Cloned Course name: " + clonedCourse.getCourseName());
		System.out.println("Original Course name: " + course1.getCourseName());
		System.out.println("  ");
		System.out.println("Clone NumberOfStudents: " + clonedCourse.getNumberOfStudents());
		System.out.println("Original NumberOfStudents: " + course1.getNumberOfStudents());
		System.out.println("  ");
		System.out.println("Cloned Course Students: " + clonedCourse.getStudent());
		System.out.println("Original Course Students: " + course1.getStudent());
	}

}

// Begin Ron's Code
/** 
*	Program: 	Course Class
* 	File: 		Course.java
* 	Summary: 	Chapter 10, Exercise 10.9  Write a test program that creates a course, adds three students, removes one, and displays the students in the course. 
* 	Author: 	Ronald Pearl
* 	Date: 		July 13, 2016 
**/

class Course implements Cloneable {
	private String courseName; 
	private String[] students = new String[0];
	private int numberOfStudents;

	public Course(String courseName) { 
		this.courseName = courseName; 
	} 

	public void addStudent(String student) {
		String[] tempStudents = new String[students.length + 1];
		tempStudents[0] = student;

		for (int i = 1; i <= students.length; i++) {
			tempStudents[i] = students[i-1];
		}
		
		students = tempStudents;
		numberOfStudents++;
	}

	public String[] getStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public String getCourseName() {
		return courseName;
	}

	public void dropStudent(String student) {
		String[] tempStudents = new String[students.length - 1];
		int counter = 0;
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] != student) {
				tempStudents[counter] = students[i];
				counter++;
			}
		}
		
		students = tempStudents;
		numberOfStudents--;
	}
	
	// Remove all students from the class
	public void clear() {
		students = new String[0];
		
		numberOfStudents = 0;
	}
	// End Ron's Code
	// Begin Lee's added Code 
	@Override // clones one course to create exact new course 
	public Object clone() throws CloneNotSupportedException {
		Course courseClone = (Course)super.clone();
		return courseClone;
	}
	public String getStudent(){
		// Returns all students in the students string array 
		String names = " ";
		for (int i = 0; i < students.length; i++){
			names += " " + students[i] + ",";
		}
		return names;
	}
	
	
} 