package HeapAndSort.Sorting;

import java.util.List;

public class MergeSort <T extends Comparable<T>> implements Sorter<T>{
    @Override

    public List<T> sort(List<T> array) {
        return mergeSort(array, 0, array.size() - 1);
    }

    private List<T> mergeSort(List<T> array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
        return array;
    }

    private void merge(List<T> array, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        T[] temp = (T[]) new Comparable[end - start + 1];
        while (i <= mid && j <= end) {
            if (array.get(i).compareTo(array.get(j)) < 0) {
                temp[k++] = array.get(i++);
            } else {
                temp[k++] = array.get(j++);
            }
        }
        while (i <= mid) {
            temp[k++] = array.get(i++);
        }
        while (j <= end) {
            temp[k++] = array.get(j++);
        }
        for (int l = 0; l < temp.length; l++) {
            array.set(start + l, temp[l]);
        }
    }
}


