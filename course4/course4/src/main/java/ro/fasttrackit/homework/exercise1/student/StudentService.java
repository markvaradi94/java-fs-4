package ro.fasttrackit.homework.exercise1.student;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.*;

@Builder
@RequiredArgsConstructor
public class StudentService {
    private final List<Student> students;

    public String studentsAverageGrade() {
        return students.stream()
                .collect(teeing(
                        mapping(Student::name, joining(", ")),
                        averagingDouble(Student::grade),
                        (names, average) -> names + " have an average grade of " + average
                ));
    }

    public String assignGradeToStudent(String name) {
        return switch (indexOfStudent(name)) {
            case 0, 1, 2 -> "1st grade";
            case 3 -> "5th grade";
            default -> "7th grade";
        };
    }

    private int indexOfStudent(String name) {
        return students.indexOf(findByName(name));
    }

    private Student findByName(String name) {
        return students.stream()
                .filter(student -> name.equalsIgnoreCase(student.name()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Could not find student with name " + name));
    }
}
