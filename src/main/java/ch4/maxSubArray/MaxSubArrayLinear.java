package ch4.maxSubArray;

public class MaxSubArrayLinear {
  public MaxArrayData calculateMaxSubArray(int[] array) {
    if(array.length ==0){
      return null;
    }
    int maxStart = 0, maxEnd = 0;
    long maxSum = Long.MIN_VALUE, currentSum = 0;

    for (int i=0; i<array.length; i++) {
      currentSum += array[i];
      if(currentSum > maxSum) {
        maxEnd = i;
        maxSum = currentSum;
      }
      if(currentSum < 0) {
        currentSum = 0;
        if(i+1 <array.length) {
          maxStart = i+1;
        }
      }
    }
    return new MaxArrayData(maxStart, maxEnd, maxSum);
  }
}
