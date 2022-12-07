package ro.fasttrackit.homework.exercise1.course;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ro.fasttrackit.homework.exercise1.student.Student;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Optional.ofNullable;

@Builder
@RequiredArgsConstructor
public class CourseService {
    private final List<Course> courses;
    private final ObjectMapper mapper = new ObjectMapper();

    public CourseService(String coursesJson) {
        this.courses = mapJsonToCourses(coursesJson);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void assignStudentsToCourses(List<Student> students) {
        students.forEach(this::printStudentCourse);
    }

    private void printStudentCourse(Student student) {
        ofNullable(student)
                .map(Student::name)
                .ifPresent(name -> System.out.println(studentMessage(name)));
    }

    private String studentMessage(String name) {
        return name + " will participate in course " + randomCourse();
    }

    private Course randomCourse() {
        return courses.get(ThreadLocalRandom.current().nextInt(0, courses.size()));
    }

    @SneakyThrows
    private List<Course> mapJsonToCourses(String coursesJson) {
        return mapper.readValue(coursesJson, new TypeReference<>() {
        });
    }
}
