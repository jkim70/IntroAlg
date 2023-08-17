package ch1.sort;

public class InsertionSort implements ISort{
  @Override
  public void sort(int[] numbers) {
    for(int i = 1; i<numbers.length; i++) {
      int current = numbers[i];
      int comparingIndex = i - 1;
      while (comparingIndex >= 0 && numbers[comparingIndex] > current) {
        numbers[comparingIndex + 1] = numbers[comparingIndex];
        comparingIndex--;
      }
      numbers[comparingIndex + 1] = current;
    }
  }
}
