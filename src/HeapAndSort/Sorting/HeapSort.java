package HeapAndSort.Sorting;

import HeapAndSort.BinHeap.BinaryHeap;
import HeapAndSort.BinHeap.BinaryHeapMax;

import java.util.List;

public class HeapSort<T extends Comparable<T>> implements Sorter<T>{
    @Override
    public List<T> sort(List<T> array) {
        BinaryHeap<T> heap = new BinaryHeapMax<>(array.size());
        heap.build(array);
        for (int i = array.size() - 1; i > -1; i--){
            array.set(i, heap.getMax());
            heap.deleteMax();
        }
        return array;
    }
}
