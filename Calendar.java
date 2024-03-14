public class Calendar {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: java Calendar <year>");
            return;
        }

        int givenYear = Integer.parseInt(args[0]);

        // Iterate through each month
        for (int month = 1; month <= 12; month++) {
            int daysInMonth = daysInMonth(month, givenYear);

            // Iterate through each day of the month
            for (int day = 1; day <= daysInMonth; day++) {
                System.out.print(day + "/" + month + "/" + givenYear);

                // Determine the day of the week
                int dayOfWeek = getDayOfWeek(day, month, givenYear);
                if (dayOfWeek == 7) {
                    System.out.print(" Sunday");
                }

                System.out.println();
            }
        }
    }

    // Zeller's Congruence algorithm to determine the day of the week
    public static int getDayOfWeek(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int h = (day + (13 * (month + 1)) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        return (h + 5) % 7 + 1; // Convert result to match 1 = Sunday, 2 = Monday, ..., 7 = Saturday
    }

    // Returns the number of days in a given month and year
    public static int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    // Returns true if the given year is a leap year, false otherwise
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
