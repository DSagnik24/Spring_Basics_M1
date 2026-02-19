package Stream;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.Comparator;
import java.util.List;


public class Main{
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("A", 22, 21),
                new Student("B", 22, 23),
                new Student("C", 80, 40),
                new Student("D", 90, 45)
        );

        List<Student> res = students.stream()
                .filter(s -> s.marks > 75)
                .toList();

        List<Student> res2 = students.stream()
                .filter(s -> s.age > 35)
                .map(s -> new Student(s.name, s.marks * 2, s.age))
                .toList();

        System.out.println(res.size());

        for (Student s : res2) {
            System.out.println(s.toString());
        }

        System.out.println();
        List<Student> passes = students.stream()
                .filter(s -> s.marks > 60)
                .peek(s -> System.out.println("Passed: " + s.name))
                .peek(s->s.setMarks(s.marks*2)) // mutating
                .map(s -> new Student(s.name, s.marks * 2, s.age))//transform
                .peek(System.out::println)
                .toList();

        for (Student s : passes) {
            System.out.println(s.toString());
        }
        System.out.println();

        List<Student> sorting = students.stream()
                .sorted(Comparator.comparing(s ->s.age))
                .toList();

        System.out.println(sorting.toString());
    }
}
