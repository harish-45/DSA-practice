package Unit4.Queue.Implementation;

public class UsingArray {

    static class Queue<E> {
        E[] arr;
        int front;
        int rear;
        int size;

        @SuppressWarnings("unchecked")
        public Queue() {
            arr = (E[]) new Object[100];
            front = -1;
            rear = -1;
            size = 0;
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public void add(E value) {
            if (rear == arr.length) {
                System.out.println("Queue is full");
                return;
            }
            arr[++rear] = value;
            size++;
            if (front == -1) {
                front++;
            }
            System.out.println("Value added : " + value);
        }

        public void remove() {
            if (front == -1) {
                System.out.println("Queue is Empty");
                return;
            }

            System.out.println("Element Removed " + arr[front]);

            if (rear == front) {
                rear--;
                front--;
                return;
            }

            for (int i = 1; i < size; i++) {
                E elem = arr[i];
                arr[i - 1] = elem;
            }

            size--;
            rear--;
        }

        public void printQueue() {
            System.out.print("-->> ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " , ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.printQueue();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

    }
}
