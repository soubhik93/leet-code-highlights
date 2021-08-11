/*
* OLA interview
* Given two numbers a and b. The result of the method should be a/b.
* 10/2 = "5.0"
* 1/2  = ".5"
* 10/3 = 3.(3)
*
* */


import java.util.ArrayList;
import java.util.List;

public class RecursiveDivisionRepresentation {

    public static String divide(int a, int b) {
      if(b == 0) throw new RuntimeException("Invalid b");
      if(a == 0) return "0.0";

      if(a % b == 0) return a/b + ".0";

      List<Integer> numerators = new ArrayList<>();

      String result;
      int rem = 0;
      if(a > b) {
        result = a/b +".";
        rem = a % b;
      } else {
        result = ".";
        rem = a;
      }
      do {
        int numerator = 10 * rem;
        if(numerators.isEmpty()) {
          numerators.add(numerator);
        } else {
          if(numerators.contains(numerator)){
            int common = numerator / b;
            int lastIndex = result.lastIndexOf(common+"");
            result = result.substring(0, lastIndex) + "(" + result.substring(lastIndex) + ")";
            break;
          } else {
            numerators.add(numerator);
          }
        }
        result = result + numerator / b;
        rem = numerator % b;
      }while( rem % b  != 0);

      return result;
    }

  public static void main(String[] args) {
    System.out.println(divide(7,12));
    System.out.println(divide(29,12));
    System.out.println(divide(1000,3));

  }

}
