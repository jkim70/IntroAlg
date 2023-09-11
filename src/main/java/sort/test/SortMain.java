package sort.test;

import ch1.sort.InsertionSort;
import ch1.sort.MergeSort;
import ch6.sort.HeapSort;
import ch7.sort.QuickSort;
import ch8.sort.CountingSort;

import java.util.StringJoiner;

public class SortMain {
  public static void main(String[] args) {
    System.out.println("# size, mergeSort, heapSort, quickSort, countingSort, insertion");
    for(int loop=0; loop<10; loop++) {
      int size = 2000 * (int)Math.pow(2.0, loop);

      System.out.print(size + ", ");
      int[] data = new int[size];
      int[] mergeData = new int[size];
      int[] heapData = new int[size];
      int[] quickData = new int[size];
      int[] countingData = new int[size];

      for (int i = 0; i < size; i++) {
        data[i] = (int) (Math.random() * size * 10);
        mergeData[i] = data[i];
        heapData[i] = data[i];
        quickData[i] = data[i];
        countingData[i] = data[i];
      }

      long start = System.currentTimeMillis();
      new MergeSort().sort(mergeData);
      System.out.print((System.currentTimeMillis() - start) + ", ");
      //print(data2);
      //System.out.println("MergeEnd");

      start = System.currentTimeMillis();
      new HeapSort().sort(heapData);
      System.out.print((System.currentTimeMillis() - start) + ", ");

      start = System.currentTimeMillis();
      new QuickSort().sort(quickData);
      System.out.print((System.currentTimeMillis() - start) + ", ");


      start = System.currentTimeMillis();
      new CountingSort().sort(countingData);
      System.out.print((System.currentTimeMillis() - start) + ", ");

      start = System.currentTimeMillis();
      new InsertionSort().sort(data);
      System.out.println((System.currentTimeMillis() - start) );

      for (int i = 0; i < size; i++) {
        assert data[i] == mergeData[i];
        assert data[i] == heapData[i];
        assert data[i] == quickData[i];
        assert data[i] == countingData[i];
      }
    }
  }

  public static void print(int[] data) {
    StringJoiner sj = new StringJoiner(", ");
    for(int i=0; i<data.length; i++){
      sj.add(String.valueOf(data[i]));
    }
    System.out.println(sj.toString());
  }
}
