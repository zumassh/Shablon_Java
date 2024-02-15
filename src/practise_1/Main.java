package practise_1;

@FunctionalInterface
interface Comparator<T>{
    int compare(T obj1, T obj2);
}
public class Main {
    public static void main(String[] args) {
        Comparator<Student> comp = (st1, st2) -> Integer.compare(st1.ball, st2.ball);

        Student s1 = new Student(34, "Vasya");
        Student s2 = new Student(50, "Asya");

        System.out.println(comp.compare(s1, s2));
        System.out.println(comp.compare(s2, s1));
    }
}