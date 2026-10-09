package Unit4.Queue.Implementation;

public class UsingLL {

    static class Queue<E> {
        Node<E> front;
        Node<E> rear;

        public boolean isEmpty() {
            return front == null;
        }

        public void add(E value) {
            Node<E> newNode = new Node<E>(value);

            System.out.println("value added : " + value);

            if (isEmpty()) {
                front = newNode;
                rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = rear.next;
        }

        public void remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty..");
                return;
            }

            System.out.println("Element Removed : " + front.value);
            front = front.next;
        }

    }

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

    }

}
