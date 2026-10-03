package Unit4.Stack.Implementation;

import java.util.ArrayList;

public class UsingArrayList {

    static class Stack<E> {
        private ArrayList<E> list;
        static int top;

        public Stack() {
            list = new ArrayList<>();
        }

        public void isEmpty() {
            if (list.size() == 0) {
                System.out.println("stack is empty");
            }
        }

        public void peek() {
            if (list.size() == 0) {
                System.out.println("stack is empty");
                return;
            }
            System.out.println("top Element : " + list.getLast());
        }

        public void push(E value) {
            list.add(value);
            System.out.println("Elem Inserted : " + value);
        }

        public void pop() {
            if (list.size() == 0) {
                System.out.println("stack is empty");
                return;
            }
            System.out.println("Elem removed : " + list.getLast());
            list.removeLast();
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
