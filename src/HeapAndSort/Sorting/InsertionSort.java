package HeapAndSort.Sorting;

import java.util.List;

public class InsertionSort <T extends Comparable<T>> implements Sorter<T>{

    public List<T> sort(List<T> array) {
        for (int i = 1; i < array.size(); i++) {
            T key = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j).compareTo(key) > 0) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, key);
        }
        return array;
    }

}
