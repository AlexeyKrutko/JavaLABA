import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Класс Student
class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void promote() {
        this.course++;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', group='" + group + "', course=" + course + ", averageGrade=" + getAverageGrade() + "}";
    }
}

// Основной класс
 class StudentManagement {

    // Метод для удаления студентов со средним баллом < 3 и перевода остальных на следующий курс
    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove(); // Удаление студента
            } else {
                student.promote(); // Перевод на следующий курс
            }
        }
    }

    // Метод для печати студентов на определенном курсе
    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
        System.out.println();
    }

    // Точка входа в программу
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Добавление студентов в список
        students.add(new Student("Алексей", "Группа 1", 1, List.of(4, 5, 3, 2)));
        students.add(new Student("Мария", "Группа 2", 1, List.of(2, 3, 4, 5)));
        students.add(new Student("Иван", "Группа 1", 2, List.of(3, 4, 5)));
        students.add(new Student("Елена", "Группа 2", 2, List.of(5, 5, 4)));

        // Обработка студентов: удаление и перевод
        processStudents(students);

        // Печать студентов на курсе 2
        printStudents(students, 2);

        // Печать студентов на курсе 3
        printStudents(students, 3);
    }
}
