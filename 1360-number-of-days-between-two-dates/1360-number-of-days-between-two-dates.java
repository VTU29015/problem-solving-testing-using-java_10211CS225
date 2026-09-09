class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFromStart(date1) - daysFromStart(date2));
    }

    private int daysFromStart(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int totalDays = 0;

        // Add days from previous years
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // Add days from previous months
        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m - 1];

            if (m == 2 && isLeapYear(year)) {
                totalDays++;
            }
        }

        // Add current day
        totalDays += day;

        return totalDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}
