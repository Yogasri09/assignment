class Course {
    String[] students = new String[10];
    int count = 0;

    void addStudent(String name) {
        students[count] = name;
        count++;
    }

    void listStudents() {
        System.out.println("Enrolled Students:");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Course c = new Course();
        c.addStudent("Anjali");
        c.addStudent("Arjun");
        c.addStudent("Priya");
        c.listStudents();
    }
}
