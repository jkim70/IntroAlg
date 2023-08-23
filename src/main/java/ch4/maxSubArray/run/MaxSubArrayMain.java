package ch4.maxSubArray.run;

import ch4.maxSubArray.MaxArrayData;
import ch4.maxSubArray.MaxSubArray;
import ch4.maxSubArray.MaxSubArrayLinear;

public class MaxSubArrayMain {
  public static void main(String[] args) {
    int[] data = {-2, -3, 4, -1, -2, 1, 5, -3};
    runMaxSub(data);

    int[] data2 = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    runMaxSub(data2);
  }

  private static void runMaxSub(int[] data) {
    MaxArrayData maxSub = new MaxSubArray().calculateMaxSubArray(data);
    MaxArrayData maxSubLinear = new MaxSubArrayLinear().calculateMaxSubArray(data);
    //It prints MaxArrayData[lowIndex=7, maxIndex=10, sum=43]
    System.out.println(maxSub.toString());
    System.out.println(maxSubLinear.toString());

    //To enable it: add '-ea' to the VM arguments
    assert maxSub.equals(maxSubLinear);
  }
}
