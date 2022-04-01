package HeapAndSort.Sorting;

import java.util.List;

public class BubbleSort <T extends Comparable<T>> implements Sorter<T>{

    public List<T> sort(List<T> array) {
        for(int i = 0; i < array.size(); i++) {
            for(int j = 0; j < array.size() - i - 1; j++) {
                if(array.get(j).compareTo(array.get(j + 1)) > 0) {
                    T temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }
        return array;
    }
}
