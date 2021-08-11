/*
K’th Smallest/Largest Element in Unsorted Array | Set 1

Given an array and a number k where k is smaller than the size of the array,
we need to find the k’th largest element in the given array. It is given that all array elements are distinct.

Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}
3,4,7,10,15,20
6-3

k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 4
Output: 10
 */

public class KthLargestElement {

  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start;
    for(int j = start; j < end ; j++) {
      if(arr[j] <= pivot) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        i++;
      }
    }
    int temp = arr[i];
    arr[i] = arr[end];
    arr[end] = temp;

    return i;
  }


  private static int findKthSmallestElement(int[] arr, int start, int end, int k) {

    if( k >= 0 && k <= end - start + 1) {

      int pos = partition(arr, start , end);
      System.out.println(pos + "  "+ arr[pos]);
      if(pos - start == k - 1) {
        return arr[pos];
      }
      if(pos - start < k - 1) {
        return findKthSmallestElement(arr, pos + 1, end, k - pos + start - 1);
      } else {
        return findKthSmallestElement(arr, start, pos - 1, k);
      }



    }

    return Integer.MAX_VALUE;
  }


  public static void main(String[] args) {
    int[] arr = {7, 10, 4, 30, 20, 15};
    System.out.println(findKthSmallestElement(arr, 0, 5, 6- 1 + 1));
  }
}
