package HeapAndSort;

import HeapAndSort.BinHeap.BinaryHeap;
import HeapAndSort.BinHeap.BinaryHeapMax;
import HeapAndSort.Sorting.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Select An Option: \n 1. To Use The Heap\n 2. To sort some list of data\n Any Other Key. exit");
        System.out.print("=> ");
        byte option;
        boolean exit = false;
        while (!exit){
            try {
                option = reader.nextByte();
                switch (option) {
                    case 1 -> testHeap();
                    case 2 -> sort();
                    default -> exit = true;
                }
            }
            catch (Exception e){
                exit = true;
            }
        }
    }
    static void testHeap(){
        BinaryHeap<Integer> binaryHeap = new BinaryHeapMax<>(1000);
        byte option;
        boolean exit = false;
        while (! exit){
            System.out.println("Select A Process: \n 1. Insert\n 2. Delete Max item \n 3. Get Max item\n 4. Build From Scratch\n Any Other Key. exit");
            System.out.print("=> ");
            option = reader.nextByte();
            try {
                switch (option){
                    case 1:
                        System.out.print("Enter An item to insert: ");
                        binaryHeap.insert(reader.nextInt());
                        break;
                    case 2:
                        if(binaryHeap.deleteMax()) System.out.println("Deleted Successfully");
                        else System.out.println("The Heap is empty !!");
                        break;
                    case 3:
                        System.out.println("The Max. item : " + binaryHeap.getMax());
                        break;
                    case 4:
                        binaryHeap.build(getIntList());
                        System.out.println("Heap built");
                        break;
                    default:
                        exit = true;
                }
            }
            catch (Exception e){
                exit = true;
            }
        }
    }
    static void sort(){
        Sorter<Integer> sorter;
        boolean exit = false;
        byte option = reader.nextByte();
        List<Integer> result = new ArrayList<>();
        while (!exit){
            System.out.println("Select A Sorting Technique: \n");
            System.out.println(" 1. Selection Sort  2. Bubble Sort  3. Insertion Sort\n 4. Merge Sort  5. Quick Sort  6. Heap Sort\n Any Other Key. exit");
            System.out.print("=> ");
            try {
                switch (option) {
                    case 1 -> {
                        sorter = new SelectionSort<>();
                        result = sorter.sort(getIntList());
                    }
                    case 2 -> {
                        sorter = new BubbleSort<>();
                        result = sorter.sort(getIntList());
                    }
                    case 3 -> {
                        sorter = new InsertionSort<>();
                        result = sorter.sort(getIntList());
                    }
                    case 4 -> {
                        sorter = new MergeSort<>();
                        result = sorter.sort(getIntList());
                    }
                    case 5 -> {
                        sorter = new QuickSort<>();
                        result = sorter.sort(getIntList());
                    }
                    case 6 -> {
                        sorter = new HeapSort<>();
                        result = sorter.sort(getIntList());
                    }
                    default -> exit = true;
                }
            }
            catch (Exception e){
                exit = true;
            }
            if(!exit){
                for(Integer num: result) System.out.print(num + " ");
                System.out.println();
            }
        }
    }

    private static List<Integer> getIntList(){
        Scanner listReader = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.print("Enter The List Size: ");
        int size = listReader.nextInt();
        System.out.println("Enter A List(element per line): ");
        for(int i = 0; i < size; i++) list.add(listReader.nextInt());
        return list;
    }
    private static List<Double> getDoubleList(){
        Scanner listReader = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        System.out.print("Enter The List Size: ");
        int size = listReader.nextInt();
        System.out.println("Enter A List(element per line): ");
        for(int i = 0; i < size; i++) list.add(listReader.nextDouble());
        return list;
    }
}
