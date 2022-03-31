package HeapAndSort.BinHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryHeapMax<T extends Comparable<T>> implements BinaryHeap<T>{
    private List<T> heap;
    private int lastIndex;

    public BinaryHeapMax(int capacity) {
        this.heap = new ArrayList<>(capacity + 1);
        for(int i = 0; i < 1000 + 1; i++) heap.add(null);
        this.lastIndex = 0;
    }

    @Override
    public T getMax() {
        if(lastIndex == 0) return null;
        return this.heap.get(1);
    }

    @Override
    public void insert(T item) {
        if(lastIndex == this.heap.size()){
            System.out.println("Heap is Full !!");
            return;
        }
        this.heap.set(percolate_up(++lastIndex, item), item);
    }

    @Override
    public boolean deleteMax() {
        if(lastIndex == 0) return false;
        T item;
        if(lastIndex == 1) {
            item = null;
            lastIndex--;
        }
        else item = this.heap.get(lastIndex--);
        this.heap.set(percolateDown(1, item), item);
        return true;
    }

    public void build(List<T> array){ ////Floyd's
        this.heap = new ArrayList<>(array.size() + 1);
        this.heap.add(null);
        heap.addAll(array);
        lastIndex = array.size();
        for(int i = lastIndex / 2; i > 0; i--){
            T item = this.heap.get(i);
            this.heap.set(percolateDown(i, item), item);
        }
    }

    private int percolate_up(int index, T value){
        while (index > 1 && this.heap.get(index /2).compareTo(value) < 0) {
            this.heap.set(index, this.heap.get(index / 2));
            index = index / 2;
        }
        return index;
    }

    private int percolateDown(int index, T value){
        int left, right, target;
        while (2 * index <= lastIndex){
            left = 2 * index;
            right = left + 1;
            target = left;
            if(right <= lastIndex && this.heap.get(left).compareTo(this.heap.get(right)) < 0)
                target = right;
            if(this.heap.get(target).compareTo(value) > 0){
                this.heap.set(index, this.heap.get(target));
                index = target;
            }
            else break;
        }
        return index;
    }
}
