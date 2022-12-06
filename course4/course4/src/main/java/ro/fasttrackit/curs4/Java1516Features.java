package ro.fasttrackit.curs4;

import java.util.concurrent.atomic.AtomicInteger;

public class Java1516Features {
    public static void main(String[] args) {
        records();
        sealedClasses();
    }

    private static void sealedClasses() {

    }

    private static void records() {
        var person = new Person("Ana", 29);
        System.out.println(person.name());
        System.out.println(person.age());
        person.getOlder();
        System.out.println(person);
    }
}

record Person(String name, AtomicInteger age) {
    public Person {
        if (age.get() > 18) {
            name = "mr. " + name;
        }
    }

    public Person(String name) {
        this(name, new AtomicInteger(20));
    }

    public Person(String name, int age) {
        this(name, new AtomicInteger(age));
    }

    public void getOlder() {
        age.incrementAndGet();
    }

    public int calculateHeight() {
        age.incrementAndGet();
        return 150 + this.age.get();
    }
}

sealed class Human permits Student, Teacher, Director {

}

final class Student extends Human {


}

non-sealed class Teacher extends Human {

}

class MathTeacher extends Teacher {

}

sealed class Director extends Human {


}

final class DirectorAdjunct extends Director {

}

final class DirectorPrincipal extends Director {

}
