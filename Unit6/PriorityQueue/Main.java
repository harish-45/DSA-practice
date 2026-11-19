package Unit6.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student obj) {
            if (this.rank == obj.rank) {
                return 0;
            } else {
                return this.rank > obj.rank ? 1 : -1;
            }
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(40);
        pq.add(30);
        pq.add(50);
        pq.add(20);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }

        PriorityQueue<Student> pQueue = new PriorityQueue<>();
        pQueue.add(new Student("Alice", 100));
        pQueue.add(new Student("Bob", 80));
        pQueue.add(new Student("Charlie", 90));

        while (!pQueue.isEmpty()) {
            System.out.println(pQueue.peek().name + " -> " + pQueue.peek().rank);
            pQueue.remove();
        }
    }
}
