package ro.fasttrackit.homework.exercise1;

import ro.fasttrackit.homework.exercise1.course.CourseService;
import ro.fasttrackit.homework.exercise1.student.Student;
import ro.fasttrackit.homework.exercise1.student.StudentService;

import java.util.List;

import static java.time.LocalDate.now;

public class Exercise1Main {
    public static void main(String[] args) {
        var students = List.of(
                Student.builder()
                        .name("Gyuszi")
                        .grade(7D)
                        .birthDate(now().minusYears(16))
                        .build(),
                Student.builder()
                        .name("Reniti")
                        .grade(9D)
                        .birthDate(now().minusYears(17))
                        .build(),
                Student.builder()
                        .name("Markuci")
                        .grade(9D)
                        .birthDate(now().minusYears(18))
                        .build(),
                Student.builder()
                        .name("Zsigmond")
                        .grade(6D)
                        .birthDate(now().minusYears(20))
                        .build(),
                new Student("Beluci", 10D, 28)
        );

        var coursesJson = """
                [
                    {
                        "name":"Math 101",
                        "semester":2
                    },
                    {
                        "name":"Physics 201",
                        "semester":1
                    },
                    {
                        "name":"History 303",
                        "semester":2
                    },
                    {
                        "name":"Logic 404",
                        "semester":2
                    }
                ]""";

        var courseService = new CourseService(coursesJson);
        System.out.println(courseService.getCourses());
        courseService.assignStudentsToCourses(students);

        var studentService = new StudentService(students);
        System.out.println(studentService.studentsAverageGrade());
        System.out.println(studentService.assignGradeToStudent("reniti"));
        System.out.println(studentService.assignGradeToStudent("zsigmond"));
        System.out.println(studentService.assignGradeToStudent("beluci"));
    }
}
