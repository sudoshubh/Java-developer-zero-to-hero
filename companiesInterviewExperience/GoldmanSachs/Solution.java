package companiesInterviewExperience.GoldmanSachs;

/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average grade.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [["Bobby", "87"],
 **   ["Charles", "100"],
 **   ["Eric", "64"],
 **   ["Charles", "22"]].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
     ** Find the best average grade.
     */
    public static int bestAverageGrade(String[][] scores) {

        if (scores == null || scores.length == 0) {
            return 0;
        }

        // Map: name -> [sum, count]
        Map<String, int[]> map = new HashMap<>();

        for (String[] entry : scores) {
            String name = entry[0];
            int score = Integer.parseInt(entry[1]);

            map.putIfAbsent(name, new int[] { 0, 0 });
            int[] arr = map.get(name);

            arr[0] += score; // sum
            arr[1] += 1; // count
        }

        int best = Integer.MIN_VALUE;

        // Compute floor averages and track the highest
        for (int[] value : map.values()) {
            int sum = value[0];
            int count = value[1];

            int avg = (int) Math.floor(sum * 1.0 / count);

            best = Math.max(best, avg); // ← missing in your code
        }

        return best;
    }

    /*
     ** Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        String[][] tc1 = {
                { "Bobby", "87" },
                { "Charles", "100" },
                { "Eric", "64" },
                { "Charles", "22" }
        };

        // Expected:
        // Bobby = 87
        // Charles = floor((100+22)/2) = 61
        // Eric = 64
        // Best = 87
        if (bestAverageGrade(tc1) != 87)
            return false;

        // Single student multiple scores
        String[][] tc2 = {
                { "John", "50" },
                { "John", "100" },
                { "John", "75" }
        };
        // avg = floor(225/3) = 75
        if (bestAverageGrade(tc2) != 75)
            return false;

        // Negative scores
        String[][] tc3 = {
                { "A", "-10" },
                { "B", "-20" },
                { "B", "0" }
        };
        // A = -10, B = floor(-20/2) = -10 → best = -10
        if (bestAverageGrade(tc3) != -10)
            return false;

        // Empty input
        String[][] tc4 = {};
        if (bestAverageGrade(tc4) != 0)
            return false;

        return true;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass!");
        } else {
            System.out.println("There are test failures.");
        }
    }
}