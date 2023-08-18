package ch4.maxSubArray.run;

import ch4.maxSubArray.MaxArrayData;
import ch4.maxSubArray.MaxSubArray;
public class MaxSubArrayMain {
  public static void main(String[] args) {
    int[] data = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    MaxArrayData answer = new MaxSubArray().calculateMaxSubArray(data);

    //It prints MaxArrayData[lowIndex=7, maxIndex=10, sum=43]
    System.out.println(answer.toString());
  }
}
