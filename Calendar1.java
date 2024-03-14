public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int SundaysCounter = 0; // Counter of Sundays that occurred on the first day of the month 
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occurred on the first day of the month.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0; 
	 	while (year < 2000) {
			System.out.print(dayOfMonth +"/" + month + "/" + year);	
			if (dayOfWeek == 1)
				System.out.print(" Sunday");
	        System.out.println();
			if (dayOfMonth == 1 && dayOfWeek == 1)
			   SundaysCounter++;
	 		advance();
	 		debugDaysCounter++;
			int n = 1000000;  // Limit for the debugger
	 		if (debugDaysCounter == n) { 
	 			break;
	 		}
        }
	 	System.out.println("During the 20th century, " + SundaysCounter + " Sundays fell on the first day of the month");
	}
	
	// Advances the date (day, month, year) and the day-of-the-week.
	// If the month changes, sets the number of days in this month.
	// Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	private static void advance() {
		nDaysInMonth = nDaysInMonth(month, year);
		if (dayOfWeek < 7)
			dayOfWeek++;
		else
			dayOfWeek = 1;
		dayOfMonth++;
		if (dayOfMonth > nDaysInMonth) {
			dayOfMonth = 1;
			month++;
			if(month > 12) {
				month = 1;
				year++;
			}
		}
	}
	
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    boolean isLeap;
		isLeap = ((year % 400) == 0);
		isLeap = isLeap || (((year % 4) == 0) && ((year % 100) != 0));
		return isLeap;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
		}
		if (month == 2 && isLeapYear(year))
			return 29;
		else
			return 28;
	}
}
