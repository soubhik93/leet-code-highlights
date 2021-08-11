/*
Given the arrival and departure times of all trains that reach a railway station,
the task is to find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays that represent the arrival and departure times of trains that stop.

Examples:

Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
Explanation: There are at-most three trains at a time (time between 11:00 to 11:20)

Input: arr[] = {9:00, 9:40}
dep[] = {9:10, 12:00}
Output: 1
Explanation: Only one platform is needed.
 */


import java.util.Arrays;

public class TrainStationProblem {

  private static int findMinNumberOfStations(int[] arr, int[] dep) {
    Arrays.sort(arr);
    Arrays.sort(dep);

    int result = 1;
    int platforms = 1;
    int i = 1;
    int j = 0;
    int size = arr.length;
    while (i < size && j < size) {
      if (arr[i] <= dep[j]) {
        platforms++;
        i++;

      } else if (arr[i] > dep[j]) {
        platforms--;
        j++;

      }

      if (result < platforms) {
        result = platforms;
      }

    }

    return result;


  }

  public static void main(String[] args) {
    int arr[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

    System.out.println(findMinNumberOfStations(arr, dep));
  }

}
