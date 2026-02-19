package Stream;


public class Student {
    String name;
    int marks;
    int age;
    public Student(String name, int marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public void setMarks(int marks){
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                ", age=" + age +
                '}';
    }
}
