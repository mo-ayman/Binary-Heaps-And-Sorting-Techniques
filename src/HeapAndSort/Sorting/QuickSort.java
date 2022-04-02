package HeapAndSort.Sorting;
import java.util.ArrayList;
import java.util.List;

public class QuickSort <T extends Comparable<T>> implements Sorter<T>{
    List<T> result ;
    @Override
    public List<T> sort(List<T> array){
        result = new ArrayList<>(array.size());
        result.addAll(array);
        quickSort(0, array.size() - 1);
        return result;
    }


    private void quickSort(int left, int right) {
        if(left >= right) return ;
        int pos = quickSortPartioning(left, right , result.get(right));
        quickSort(left, pos - 1);
        quickSort(pos + 1, right);
    }

    private int quickSortPartioning(int left, int right, T pivot){
        int low = left, high = right -1;
        while (true){
            while (low < right && result.get(low).compareTo(pivot) <= 0) low++;
            while (high > left && result.get(high).compareTo(pivot) >= 0) high--;
            if(low < high) swap(low, high);
            else break;
        }
        swap(low, right);
        return low;
    }

    private void swap(int index1, int index2){
        T item = result.get(index1);
        result.set(index1, result.get(index2));
        result.set(index2, item);
    }
}
