package HeapAndSort;

import HeapAndSort.Sorting.HeapSort;
import HeapAndSort.Sorting.QuickSort;
import HeapAndSort.Sorting.Sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Random value = new Random();
            Integer item = (value.nextInt(100));
            System.out.println(item);
            temp.add(item);
        }
        Sorter<Integer> sorter = new HeapSort<>();
        Sorter<Integer> sorter1 = new QuickSort<>();
        temp = sorter1.sort(temp);
//        temp = sorter.sort(temp);
        for (int i = 0; i < 10; i++){
            System.out.println(":"+temp.get(i));
        }
    }
}
