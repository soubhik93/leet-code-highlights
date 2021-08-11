/*
Find the median of the running integers
Tutorial:
https://www.youtube.com/watch?v=EcNbRjEcb14
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfARunningArray {

  private static float[] findRunningMedian(int[] arr) {

    float[] result = new float[arr.length];
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < arr.length; i++) {
      if (max.isEmpty() || max.peek() >= arr[i]) {
        max.add(arr[i]);
      } else {
        min.add(arr[i]);
      }

      if (max.size() > min.size() + 1) {
        min.add(max.poll());
      } else if (min.size() > max.size() + 1) {
        max.add(min.poll());
      }

      float rMedian;

      if (max.size() == min.size()) {
        rMedian = (max.peek() + min.peek()) / 2.0f;
      } else if (max.size() > min.size()) {
        rMedian = max.peek();
      } else {
        rMedian = min.peek();
      }
      System.out.println(rMedian);
      result[i] = rMedian;
    }
    return result;
  }


  public static void main(String[] args) {
    int[] arr = new int[]{5, 15, 10, 20, 3};
    System.out.println(findRunningMedian(arr));
  }

}
