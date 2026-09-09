class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
        };

        int totalDays = 0;

        // Count days from 1971 to the year before the given year
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Count days from previous months
        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m - 1];

            if (m == 2 && isLeapYear(year)) {
                totalDays++;
            }
        }

        // Add days before the given day
        totalDays += day - 1;

        // January 1, 1971 was Friday
        // Sunday = 0, Monday = 1, ..., Friday = 5
        int index = (5 + totalDays) % 7;

        return days[index];
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}
