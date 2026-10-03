package Unit4.Stack.Implementation;

public class UsingLinkedList {
    static class Stack<E> {
        Node<E> top;

        public Stack() {
        }

        public void isEmpty() {
            if (top == null) {
                System.out.println("stack is empty");
            }
        }

        public void push(E value) {
            Node<E> newNode = new Node<>(value);
            newNode.next = top;
            top = newNode;

            System.out.println("Elem Inserted : " + value);
        }

        public void peek() {
            if (top == null) {
                System.out.println("stack is empty");
                return;
            }
            System.out.println("top Elem : " + top.getValue());
        }

        public void pop() {
            if (top == null) {
                System.out.println("stack is empty");
                return;
            }
            System.out.println("Elem removed : " + top.getValue());
            top = top.next;
        }
    }

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.isEmpty();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

    }
}
