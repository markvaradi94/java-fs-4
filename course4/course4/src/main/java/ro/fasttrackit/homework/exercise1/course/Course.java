package ro.fasttrackit.homework.exercise1.course;

import lombok.Builder;

@Builder
public record Course(
        String name,
        int semester
) {
}
