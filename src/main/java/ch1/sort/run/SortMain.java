package ch1.sort.run;

import ch1.sort.InsertionSort;
import ch1.sort.MergeSort;

import java.util.StringJoiner;

public class SortMain {
  public static void main(String[] args) {
    System.out.println("# size, merge, insertion");
    for(int loop=0; loop<10; loop++) {
      int size = 2_000 * (int)Math.pow(2.0, loop);

      System.out.print(size + ", ");
      int[] data = new int[size];
      int[] data2 = new int[size];
      for (int i = 0; i < size; i++) {
        data[i] = (int) (Math.random() * size * 10);
        data2[i] = data[i];
      }

      long start = System.currentTimeMillis();
      new MergeSort().sort(data2);
      System.out.print((System.currentTimeMillis() - start) + ", ");
      //print(data2);
      //System.out.println("MergeEnd");
      start = System.currentTimeMillis();
      new InsertionSort().sort(data);
      System.out.println((System.currentTimeMillis() - start) );
      //print(test);
      //System.out.println("InsertionEnd");

      for (int i = 0; i < size; i++)
        assert data[i] == data2[i];
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
