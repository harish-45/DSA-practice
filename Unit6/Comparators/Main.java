package Unit6.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(50);

        MyComparator myComparator = new MyComparator();
        // in accending
        list.sort(myComparator);
        System.out.println(list);

        ArrayList<String> str = new ArrayList<>();
        str.add("Alice");
        str.add("Dogy");
        str.add("Charlie");
        str.add("Bob");

        // sort by their length
        str.sort(new StringComparator());
        System.out.println(str);

        // custom comparator for custom class

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.8));
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Dogy", 3.6));
        students.add(new Student("Bob", 3.5));

        // directly using lamda Function
        students.sort((o1, o2) -> {
            if (o2.getCgpa() - o1.getCgpa() > 0)
                return 1;
            else if (o2.getCgpa() - o1.getCgpa() < 0)
                return -1;
            else
                return 0;
        });

        // using a object of manually builds comparator class
        students.sort(new StudentComparator());

        // using a comparator directly
        Comparator<Student> comparator = Comparator.comparing(Student::getCgpa).reversed()
                .thenComparing(Student::getName);
        students.sort(comparator);

        // or use of Collection
        Collections.sort(students, comparator);
        for (Student s : students) {
            System.out.print("name: " + s.getName());
            System.out.print(" cgpa: " + s.getCgpa());
            System.out.println();
        }

    }
}

class Student {
    private String name;
    private double cgpa;

    public Student(String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // 4 , 7
        if (o2.getCgpa() - o1.getCgpa() > 0)
            return 1;
        else if (o2.getCgpa() - o1.getCgpa() < 0)
            return -1;
        else
            return 0;
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }

    // Alice , Bob

}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return a - b;
    }

    // - ve same order
    // + ve reverse the order
    // 0 same

    // 3, 5
    // 5 ,3
}
