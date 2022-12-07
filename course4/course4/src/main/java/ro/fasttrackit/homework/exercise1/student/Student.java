package ro.fasttrackit.homework.exercise1.student;


import lombok.Builder;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.LocalDate.now;

@Builder
public record Student(
        String name,
        Double grade,
        LocalDate birthDate
) {
    public Student(String name, Double grade, int age) {
        this(name, grade, randomBirthday(age));
    }

    public int age() {
        return Period.between(birthDate, now()).getYears();
    }

    private static LocalDate randomBirthday(int age) {
        var birthYear = now().getYear() - age;
        var month = Month.of(randomDay(13));

        var day = switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> randomDay(32);
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> randomDay(31);
            case FEBRUARY -> randomFebruaryDay(birthYear);
        };

        return LocalDate.of(birthYear, month, day);
    }

    private static int randomDay(int bound) {
        return ThreadLocalRandom.current().nextInt(1, bound);
    }

    private static int randomFebruaryDay(int year) {
        return year % 400 == 0 ? randomDay(30) : randomDay(29);
    }
}
