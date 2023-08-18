package ch4.maxSubArray;

public class MaxSubArray {
  public MaxArrayData calculateMaxSubArray(int[] array) {
    if(array.length ==0){
      return null;
    }
    return calculateMaxSubArray(array, 0, array.length-1);
  }

  private MaxArrayData calculateMaxSubArray(int[] array, int low, int high) {
    if(low == high) {
      return new MaxArrayData(low, high, array[low]);
    }else {
      int mid = (low+high)/2;
      MaxArrayData left = calculateMaxSubArray(array, low, mid);
      MaxArrayData right = calculateMaxSubArray(array, mid+1, high);
      MaxArrayData cross = calculateCrossMaxSubArray(array, low, mid, high);

      if(left.sum() >= right.sum() && left.sum() >= cross.sum()) {
        return left;
      }else if(right.sum() >= left.sum() && right.sum() >= cross.sum()) {
        return right;
      }else {
        return cross;
      }
    }
  }

  private MaxArrayData calculateCrossMaxSubArray(int[] array, int low, int mid, int high) {
    long maxLeft = Long.MIN_VALUE, maxRight = Long.MIN_VALUE;
    int maxLeftIndex =0, maxRightIndex=0;

    long currentSum = 0;
    for(int i=mid; i>=low; i--) {
      currentSum += array[i];
      if(currentSum > maxLeft) {
        maxLeft = currentSum;
        maxLeftIndex = i;
      }
    }

    currentSum = 0;
    for (int i = mid +1; i<=high; i++) {
      currentSum += array[i];
      if(currentSum > maxRight) {
        maxRight = currentSum;
        maxRightIndex = i;
      }
    }
    return new MaxArrayData(maxLeftIndex, maxRightIndex, (maxLeft + maxRight));
  }
}
