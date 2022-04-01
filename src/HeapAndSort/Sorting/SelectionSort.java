package HeapAndSort.Sorting;

import java.util.List;

public class SelectionSort <T extends Comparable<T>> implements Sorter<T> {
    @Override
    public List<T> sort(List<T> array) {
        for (int i = 0; i < array.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j).compareTo(array.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = array.get(i);
            array.set(i, array.get(minIndex));
            array.set(minIndex, temp);
        }
        return array;
    }

}
