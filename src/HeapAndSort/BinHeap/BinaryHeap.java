package HeapAndSort.BinHeap;

import java.util.List;

public interface BinaryHeap<T extends Comparable<T>> {
    T getMax();
    void insert(T item);
    boolean deleteMax();
    void build(List<T> array);
}
