package ro.fasttrackit.curs4;

public class SealedInterfaces {
    public static void main(String[] args) {
        sealedInterfaces();
    }

    private static void sealedInterfaces() {
//        Animal pet = new Canary();
//        var result = switch (pet) {
//            case pet instanceof Canary c -> c.makeSound();
//            case pet instanceof Dog d -> d.makeSound();
//            case pet instanceof Cat c -> c.makeSound();
//        };
    }
}

sealed interface Animal permits Cat, Dog, Bird {
    String makeSound();
}

record Cat(String name) implements Animal {
    public String makeSound() {
        return "meow, I am " + name;
    }
}

record Dog(String name) implements Animal {
    public String makeSound() {
        return "woof, I am " + name;
    }
}

sealed interface Bird extends Animal {

}

non-sealed class Canary implements Bird {
    @Override
    public String makeSound() {
        return "shut up, bird";
    }
}
