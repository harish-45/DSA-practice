package Unit4.Queue.Implementation;

public class CircularQueueArray {
    static class Queue<E> {

        E[] arr;
        int front;
        int rear;
        int n;

        @SuppressWarnings("unchecked")
        public Queue(int size) {
            arr = (E[]) new Object[size];
            front = -1;
            rear = -1;
            n = size;
        }

        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        public boolean isFull() {
            return (rear + 1) % n == front;
        }

        public void add(E value) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            rear = (rear + 1) % n;
            arr[rear] = value;
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
                rear = -1;
                front = -1;
            } else {
                front = (front + 1) % n;
            }
        }

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

    }
}
