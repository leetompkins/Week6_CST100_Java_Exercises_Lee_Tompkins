/** Program: Octagon Cloning, and Comparing 
 * Summary: A program that creates an Octagon, displays it's parimeter and area, then clones the octagon. 
 * The cloned octagon is then compared using the compareTo metod to ensure it is exactly the same as the original octagon. 
 * File: TestOctagon.java
 * Author: Lee Tompkins 
 * Date: July 25 2016 
 **/
import java.lang.Comparable;
import java.lang.Cloneable;

public class TestOctagon {

	public static void main(String[] args) throws CloneNotSupportedException {
		Octagon octagon1 = new Octagon(5);
		Octagon octagonClone = (Octagon)octagon1.clone();
		System.out.println("The parimeter of the octagon is: " + octagon1.getParimeter());
		System.out.println("The area of the octagon is: " + octagon1.getArea());
		if(octagon1.compareTo(octagonClone) == 1) {
			System.out.println("The new object is larger than the original");
		} else if(octagon1.compareTo(octagonClone) == 0) {
			System.out.println("The new object is the same as the original");
		} else {
			System.out.println("The new object is smaller than the original");
		}

	}

}

abstract class GeometricObject implements Cloneable, Comparable<Object> {
	// Data Fields that all geometric objects have 
	protected double area;
	protected double parimeter;
	
	public double getArea() {
		// returns area
		return area; 
	}
	
	public int compareTo(Octagon arg0) {
		return 0;
	}


	public double getParimeter(){
		// returns parimeter
		return parimeter;
	}
	
	
}
class Octagon extends GeometricObject {
	//Octagon specific data fields 
	private double octagonalSide;
	
	@Override // overrides super get area method
	public double getArea(){
		return (2 + (4 / Math.sqrt(2))) * octagonalSide * octagonalSide;
	}
	
	@Override // overrides super get parimeter method 
	public double getParimeter(){
		return octagonalSide * 8;
	}
	
	public Octagon(double side){ // constructor for Octagon object
		this.octagonalSide = side;
		this.area = (2 + (4 / Math.sqrt(2))) * side * side;
		this.parimeter = side * 8;
	}

	@Override
	public int compareTo(Octagon arg0) { // compares one octagon to another 
		// TODO Auto-generated method stub
		if (area > arg0.area && parimeter > arg0.parimeter) {
			return 1;
		} else if (area == arg0.area && parimeter == arg0.parimeter) {
			return 0;
		} else {
			return -1;
		}
	}
	
	@Override // clones one octagon to create exact new octagon 
	public Object clone() throws CloneNotSupportedException {
		Octagon octagonClone = (Octagon)super.clone();
		return octagonClone;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
		
	
}
