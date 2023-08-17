package ch1.sort;

public class MergeSort implements ISort{
  @Override
  public void sort(int[] numbers) {
    mergeSort(numbers, 0, numbers.length-1);
  }

  /**
   * @param numbers
   * @param start - inclusive
   * @param end - inclusive
   * @return
   */
  private void mergeSort(int[] numbers, int start, int end) {
    if (start < end) {
      int middle = (start + end) / 2;
      mergeSort(numbers, start, middle);
      mergeSort(numbers, middle + 1, end);
      merge(numbers, start, middle, end);
    }
  }

  private void merge(int[] numbers, int start, int middle, int end) {
    int leftSize = middle -start + 1;
    int rightSize = end - middle;

    int[] leftData = new int[leftSize];
    int[] rightData = new int[rightSize];

    int leftIndex = 0;
    for(int i = start; i<= middle; i++) {
      leftData[leftIndex++] = numbers[i];
    }
    int rightIndex = 0;
    for(int i = middle+1; i<=end; i++) {
      rightData[rightIndex++] = numbers[i];
    }

    leftIndex=0;
    rightIndex=0;
    int numberIndex = start;
    while(leftIndex < leftSize && rightIndex < rightSize) {
      if(leftData[leftIndex] <= rightData[rightIndex]) {
        numbers[numberIndex++] = leftData[leftIndex++];
      }else {
        numbers[numberIndex++] = rightData[rightIndex++];
      }
    }

    if(rightIndex < rightSize) {
      System.arraycopy(rightData, rightIndex, numbers, numberIndex, (rightSize - rightIndex));
    }else if(leftIndex < leftSize) {
      System.arraycopy(leftData, leftIndex, numbers, numberIndex, (leftSize - leftIndex));
    }
  }
}
