/** Program: Calendar Display 
 *  File:    DisplayCalendars.java
 *  Summary: Week6 Exercise 13.4 
 *  		 A program that displays a calendar for a specific month using Calendar
 *  		 and GregorianCalendar. The program receives the month and year from the command line.
 *  Author:  Lee Tompkins 
 *  Date:    July 25 2016
 **/




import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;





public class DisplayCalendars {

	public static void main(String[] args) {
		int[][] days = new int[6][7]; // multi-dimentional array for week days
		Scanner input = new Scanner(System.in);
		// prompt user for input
		System.out.println("To display the calender for a certain month, enter in the year followed by the month seperated by a space");
		System.out.print("Use 0 for the number of the month for January     ");
		// store user input in variables 
		int year = input.nextInt();
		int month = input.nextInt() - 1;
		MyDate calendar1 = new MyDate(year, month, 1); // construct MyDate 
		int maxDays = calendar1.getMAX(); // Set max number of days in the month to variable 
		//MyDate calendar1 = new MyDate();
		//calendar1.setYear(year);
		//calendar1.setMonth(month);
		//calendar1.setDay(1);
		//System.out.println(calendar1.getMonth());
		//System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("         " + calendar1.getMonthName() + " " + calendar1.getYear()); // print month and year 
		System.out.println("__________________________"); // print a line 
		// print days of the week
		String[] weekDays = new String[7];
		weekDays[0] = "Sun";
		weekDays[1] = "Mon";
		weekDays[2] = "Tue";
		weekDays[3] = "Wed";
		weekDays[4] = "Thu";
		weekDays[5] = "Fri";
		weekDays[6] = "Sat";
		// loop through days for array and add day number, and print each week 
		for(int i = 0; i < 7; i++) {
			System.out.print(weekDays[i] + " ");
		}
		System.out.println("");
		int x = calendar1.getWeekDay();
		days[0][x - 1] = 1;
		for(int i = x; i < 7; i++) {
			int j = 2;
			days[0][i] = j;
			j++;
		}
		for (int i = 0; i < 7; i++) {
			System.out.print(" " + days[0][i] + "  ");
		}
		System.out.println("");
		for (int i = 0; i < 7; i++) {
			int j = days[0][6]++;
			days[1][i] = j + 1;
			
		}		
		for (int i = 0; i < 7; i++) {
			System.out.print(" " + days[1][i] + "  ");
		}
		System.out.println("");
		for (int i = 0; i < 7; i++) {
			int j = days[1][6]++;
			days[2][i] = j + 1;
			
		}	
		for (int i = 0; i < 7; i++) {
			System.out.print(" " + days[2][i] + " ");
		}
		System.out.println("");
		for (int i = 0; i < 7; i++) {
			int j = days[2][6]++;
			days[3][i] = j + 1;
			
		}	
		for (int i = 0; i < 7; i++) {
			System.out.print("" + days[3][i] + "  ");
		}
		System.out.println("");
		for (int i = 0; i < 7; i++) {
			int j = days[3][6]++;
			if (j == maxDays) {
				break; // break if max number for month reached 
			}
			days[4][i] = j + 1;
			
		}	
		for (int i = 0; i < 7; i++) {
			System.out.print("" + days[4][i] + "  ");
		}
		System.out.println("");
		for (int i = 0; i < 7; i++) {
			int j = days[4][6]++;
			if(j == maxDays){
				break; // break if max number for month reached 
			}
			days[5][i] = j + 1;
			
		}	
		for (int i = 0; i < 7; i++) {
			System.out.print("" + days[5][i] + "  ");
		}
	}

	
}





// Begin Ron's MyDate class code 
/** 
*	Program: 	MyDate class
* 	File: 		MyDate.java
* 	Summary: 	Chapter 10, Exercise 10.14
*				Write a test program that creates two MyDate objects (using new MyDate() and 
*				new MyDate(34355555133101L)) and displays their year, month, and day.
*      			The first two constructors will extract the year, month, and day from the elapsed time.
* 	Author: 	Ronald Pearl
* 	Date: 		July 15, 2016 
**/



 class MyDate {
	 GregorianCalendar a = new GregorianCalendar();
    private int year = a.get(Calendar.YEAR);
    private int month = a.get(Calendar.MONTH);
    private int day = a.get(Calendar.DAY_OF_MONTH);
    private int dayOfWeek = a.get(Calendar.DAY_OF_WEEK);

    public MyDate() {

        GregorianCalendar cal = new GregorianCalendar();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        

    }

    public MyDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }

    public MyDate(int year, int month, int day) {
    	GregorianCalendar cal = new GregorianCalendar(year, month, day);
        a = cal;
    }

    public int getYear() {
        return a.get(Calendar.YEAR);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return a.get(Calendar.MONTH);
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    } // End Ron's MyDate class code 
    public String getMonthName(){
    	switch (month){ // Switch to return appropriate month 
    		case 0: {
    			return "January";
    		}
    		case 1: {
    			return "February";
    		}
    		case 2: {
    			return "March";
    		}
    		case 3: {
    			return "April";
    		}
    		case 4: {
    			return "May";
    		}
    		case 5: {
    			return "June";
    		}
    		case 6: {
    			return "July";
    		}
    		case 7: {
    			return "August";
    		}
    		case 8: {
    			return "September";
    		}
    		case 9: {
    			return "October";
    		}
    		case 10: {
    			return "November";
    		}
    		case 11: {
    			return "December";
    		}
    		
    	}
    	return "";	
    }
    public int getWeekDay(){
    	// returns 1st day of the week (Sunday = 1) 
    	return a.get(Calendar.DAY_OF_WEEK);
    }
    public int getMAX(){
    	// returns month max numbers 
    	return a.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
 
