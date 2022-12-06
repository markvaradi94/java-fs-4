package ro.fasttrackit.curs4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

import static java.lang.System.lineSeparator;
import static java.nio.file.StandardOpenOption.APPEND;

public class Java11Features {
    public static void main(String[] args) {
        stringMethods();
        lambdaAnnotations();
        fileMethods();
    }

    private static void fileMethods() {
        try {
            Path path = Path.of("simple.txt");
            Files.writeString(path, "my line" + lineSeparator(), APPEND);
            System.out.println(Files.readString(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void lambdaAnnotations() {
        Function<String, String> logic = (@JsonProperty String a) -> a + " test";
    }

    private static void stringMethods() {
        String value = "    ";
        System.out.println(value.isBlank());
        System.out.println(value.isEmpty());

        if (value.trim().isEmpty()) {
            System.out.println("it is empty");
        }

        String text = "java ";
        System.out.println(text.repeat(10));

        String unicode = "     \u0000 \u00D8    java    ";
        System.out.println(unicode.trim());
        System.out.println(unicode.strip());
        System.out.println(unicode.stripIndent() + "|");
        System.out.println(unicode.stripTrailing() + "|");
        System.out.println(unicode.stripLeading() + "|");
    }
}
