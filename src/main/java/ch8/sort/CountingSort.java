package ch8.sort;

import ch1.sort.ISort;

public class CountingSort implements ISort {
  @Override
  /**
   * This array assumes containing all 0 or positive elements.
   */
  public void sort(int[] numbers) {
    int maxE = 0;
    for (int i=0;i<numbers.length; i++) {
      if(maxE < numbers[i]) {
        maxE = numbers[i];
      }
    }

    int[] sortedNumbers = countingSort(numbers, maxE);
    System.arraycopy(sortedNumbers, 0, numbers, 0, sortedNumbers.length);
  }

  private int[] countingSort(int[] numbers, int maxE) {
    //Count is meaningful from 1, and index pointed in ths elementCount starts from 0.
    int[] elementCount = new int[maxE+1];
    int[] sortedNumbers = new int[numbers.length];
    for(int i=0; i<numbers.length; i++) {
      elementCount[numbers[i]] = elementCount[numbers[i]] + 1;
    }

    for(int i=1; i<=maxE; i++) {
      elementCount[i] += elementCount[i-1];
    }

    for(int i=numbers.length-1; i>=0; i--) {
      //Count is meaningful from 1, and index pointed in ths elementCount starts from 0.
      sortedNumbers[elementCount[numbers[i]]-1] = numbers[i];
      elementCount[numbers[i]] = elementCount[numbers[i]] -1;
    }

    return sortedNumbers;
  }
}
