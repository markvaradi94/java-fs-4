package ro.fasttrackit.curs4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.stream.IntStream;

import static java.text.NumberFormat.Style.LONG;
import static java.util.Locale.US;
import static java.util.stream.Collectors.*;

public class Java12Features {
    public static void main(String[] args) throws IOException {
        filesMismatch();
        numberFormatting();
        teeingCollectors();
        stringMethods();
        instanceOfPattern(new Person("test", 25, "address"));
    }

    private static void instanceOfPattern(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            System.out.println(person.name);
        } else if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str.length());
        }

        if (obj instanceof Person person) {
            System.out.println(person.name);
        } else if (obj instanceof String str) {
            System.out.println(str.length());
        }
    }

    private static void stringMethods() {
        String row = "Ana are mere";
        System.out.println(row.indent(4));
        String transform = row.transform(s -> s + "abc");
        System.out.println(transform);
    }

    private static void teeingCollectors() {
        Long average = IntStream.range(1, 100)
                .boxed()
                .collect(teeing(
                        summingInt(i -> i),
                        counting(),
                        (sum, count) -> sum / count
                ));
        System.out.println(average);
    }

    private static void numberFormatting() {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(US, LONG);
        System.out.println(formatter.format(1_000_000));
    }

    private static void filesMismatch() throws IOException {
        Path firstFile = Path.of("first.txt");
        Path secondFile = Path.of("second.txt");
        Path thirdFile = Path.of("third.txt");
        Files.writeString(firstFile, "content");
        Files.writeString(secondFile, "content");
        Files.writeString(thirdFile, "content diff");

        System.out.println(Files.mismatch(firstFile, secondFile));
        System.out.println(Files.mismatch(firstFile, thirdFile));
    }

    record Person(
            String name,
            int age,
            String address
    ) {
    }
}
