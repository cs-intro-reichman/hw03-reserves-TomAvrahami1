public class Calendar {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2;     // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January

    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: java Calendar <year>");
            return;
        }

        int givenYear = Integer.parseInt(args[0]);

        // Advance days until the last day of the year before the given year
        while (year < givenYear) {
            advance();
        }

        // Print the calendar for the given year
        printCalendar(givenYear);
    }

    // Prints the calendar for the given year
    private static void printCalendar(int year) {
        System.out.println("Calendar for " + year);

        // Loop through each month and print the dates
        for (int m = 1; m <= 12; m++) {
            nDaysInMonth = nDaysInMonth(m, year);
            System.out.println("Month " + m);

            // Print the days of the week
            System.out.println("Su Mo Tu We Th Fr Sa");

            // Print leading spaces for the first week
            for (int i = 1; i < dayOfWeek; i++) {
                System.out.print("   ");
            }

            // Print the dates for the current month
            for (int d = 1; d <= nDaysInMonth; d++) {
                System.out.printf("%2d", d);
                System.out.print(" ");

                // Move to the next day
                advance();

                // If it's Sunday, start a new line
                if (dayOfWeek == 1) {
                    System.out.println();
                }
            }

            // Start a new line after each month
            System.out.println();
        }
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
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    // Returns the number of days in the given month and year.
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
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1; // Invalid month
        }
    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        boolean isLeap;
        isLeap = ((year % 400) == 0);
        isLeap = isLeap || (((year % 4) == 0) && ((year % 100) != 0));
        return isLeap;
    }
}
