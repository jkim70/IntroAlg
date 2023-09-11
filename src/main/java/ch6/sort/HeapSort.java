package ch6.sort;

import ch1.sort.ISort;

public class HeapSort implements ISort {
  @Override
  public void sort(int[] numbers) {
    buildMaxHeap(numbers);

    for(int lastIndex = numbers.length-1; lastIndex >0; ) {
      int largest = numbers[0]; //largest element in the array with an index 0 to lastIndex (inclusive)
      numbers[0] = numbers[lastIndex];
      numbers[lastIndex] = largest;
      maxHeapfify(numbers, 0, --lastIndex);
    }
  }

  public void buildMaxHeap(int[] numbers) {
    for(int i = numbers.length / 2; i>=0; i--) {
      maxHeapfify(numbers, i);
    }
  }
  public void maxHeapfify (int[] numbers, int index) {
    maxHeapfify(numbers, index, numbers.length-1);
  }

  private void maxHeapfify (int[] numbers, int index, int lastIndex) {
    int left = index * 2 + 1;
    int right = left + 1;
    int largest = index;
    if(left <= lastIndex && numbers[left] > numbers[index]) {
      largest = left;
    }
    if(right <= lastIndex && numbers[right] > numbers[largest]) {
      largest = right;
    }

    if(largest != index) {
      int temp = numbers[index];
      numbers[index] = numbers[largest];
      numbers[largest] = temp;
      maxHeapfify(numbers, largest, lastIndex);
    }
  }
}
