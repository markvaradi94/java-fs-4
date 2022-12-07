package ro.fasttrackit.homework.exercise2.sealed;

public sealed interface Animal permits Dog, Cat, Bird, Insect {
    void doSomething();
}

final class Dog implements Animal {
    public void doSomething() {
        System.out.println("woof");
    }
}

record Cat() implements Animal {
    public void doSomething() {
        System.out.println("meow");
    }
}

sealed class Bird implements Animal permits Canary, Parrot, Chicken {
    public void doSomething() {
        System.out.println("chirp");
    }
}

final class Canary extends Bird {
    public void doSomething() {
        System.out.println("I'm a canary");
    }
}

final class Parrot extends Bird {
    public void doSomething() {
        System.out.println("I'm a parrot");
    }
}

non-sealed class Chicken extends Bird {
    public void doSomething() {
        System.out.println("I'm a chicken");
    }
}

non-sealed interface Insect extends Animal {

}

final class Fly implements Insect {
    public void doSomething() {
        System.out.println("I'm a stupid fly");
    }
}

record Ladybug() implements Insect {
    public void doSomething() {
        System.out.println("I'm a cute ladybug");
    }
}
