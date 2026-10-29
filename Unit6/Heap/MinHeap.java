package Unit6.Heap;

import java.util.ArrayList;

public class MinHeap {

    public static class Heap {
        ArrayList<Integer> list = new ArrayList<>();

        public void add(int val) {
            list.add(val);
            int child = list.size() - 1;
            int parent = (child - 1) / 2;

            while (list.get(child) < list.get(parent)) {
                int temp = list.get(child);
                list.set(child, list.get(parent));
                list.set(parent, temp);

                child = parent;
                parent = (child - 1) / 2;
            }
        }

        public void heapify(int i) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int minIdx = i;

            if (left < list.size() && list.get(i) > list.get(left)) {
                minIdx = left;
            }
            if (right < list.size() && list.get(i) > list.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // swap
                int temp = list.get(i);
                list.set(i, list.get(minIdx));
                list.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public void remove() {
            // swap
            int temp = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.set(list.size() - 1, temp);

            // delete last elem
            list.remove(list.size() - 1);

            // heapify
            heapify(0);
        }

        public int peek() {
            return list.get(0);
        }

        @Override
        public String toString() {
            return list.toString();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

    public static void main(String[] args) {
        Heap minHeap = new Heap();
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(10);

        System.out.println(minHeap);
        minHeap.add(1);
        System.out.println(minHeap);
        minHeap.remove();
        System.out.println(minHeap);
        System.out.println(minHeap.isEmpty());
        System.out.println(minHeap.peek());

    }
}