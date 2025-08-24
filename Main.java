class Course {
    String courseName;
    String[] students;
    int count;

    Course(String courseName, int size) {
        this.courseName = courseName;
        students = new String[size];
        count = 0;
    }

    void addStudent(String name) {
        if (count < students.length) {
            students[count] = name;
            count++;
        }
    }

    void listEnrolledStudents() {
        if (count == 0) {
            System.out.println("No students enrolled in " + courseName);
        } else {
            System.out.println("Students enrolled in " + courseName + ":");
            for (int i = 0; i < count; i++) {
                System.out.println(students[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Course c = new Course("Computer Science", 3);
        c.addStudent("Anjali");
        c.addStudent("Arjun");
        c.addStudent("Priya");
        c.listEnrolledStudents();
    }
}

