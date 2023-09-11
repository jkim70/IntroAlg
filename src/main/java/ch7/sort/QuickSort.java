package ch7.sort;

import ch1.sort.ISort;

public class QuickSort implements ISort {
  @Override
  public void sort(int[] numbers) {
    randomizedQuickSort(numbers, 0, numbers.length-1);
  }
  private void randomizedQuickSort(int[] numbers, int begin, int last) {
    if (begin < last) {
      int lastElementIndex = randomizedPartition(numbers, begin, last);
      randomizedQuickSort(numbers, begin, lastElementIndex - 1);
      randomizedQuickSort(numbers, lastElementIndex + 1, last);
    }
  }

  private void quickSort(int[] numbers, int begin, int last) {
    if(begin < last) {
      //When the input array is already sorted, this partition function separate
      // the array by one element per each recursion and may cause "StackOverflowError"
      int lastElementIndex = partition(numbers, begin, last);
      quickSort(numbers, begin, lastElementIndex - 1);
      quickSort(numbers,lastElementIndex+1, last);
    }
  }

  /**
   *
   * @param numbers
   * @param begin
   * @param last
   * @return 'index' of an element of an input numbers[last].
   *  After this method, all elements at indexes less than the return index are less than numbers[returnIndex].
   *   All elements at indexes larger than the return index are bigger than numbers[returnIndex]
   */
  private int partition(int[] numbers, int begin, int last) {
    int lastElement = numbers[last];
    int i = begin -1;
    for (int j = begin; j<=last-1; j++) {
      if(numbers[j] < lastElement) { //For descending order, change this '<' to '>'
        i++;
        if(i!=j) {
          int temp = numbers[j];
          numbers[j] = numbers[i];
          numbers[i] = temp;
        }
      }
    }

    numbers[last] = numbers[++i];
    numbers[i] = lastElement;
    return i;
  }

  private int randomizedPartition(int[] numbers, int begin, int last) {
    int randomIndex = (int)(Math.random() * (last-begin+1)) + begin;
    int randomElement = numbers[randomIndex];
    numbers[randomIndex] = numbers[last];
    numbers[last] = randomElement;
    return partition(numbers, begin, last);
  }
}
