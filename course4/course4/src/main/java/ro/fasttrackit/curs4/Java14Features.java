package ro.fasttrackit.curs4;

public class Java14Features {
    public static void main(String[] args) {
        switchExpression();
        betterNPE();
    }

    private static void betterNPE() {
        String name = null;
        System.out.println(name.length());
    }

    private static void switchExpression() {
        String choice = "pizza";
        switch (choice) {
            case "pizza":
            case "burger":
                System.out.println("Delizioso");
                break;
            case "salad":
                System.out.println("Healthy");
                break;
            default:
                System.out.println("grub");
        }

        String result = switch (choice) {
            case "pizza", "burger":
                yield "Delizioso";
            default:
                yield "food";
        };
        System.out.println(result);
        System.out.println("fallthrough?");

        String value = switch (choice) {
            case "pizza", "burger":
                System.out.println("delicious");
            case "salad":
                yield "healthy";
            default:
                yield "grub";
        };
        System.out.println(value);

        String newValue = switch (choice) {
            case "pizza", "burger" -> "Delicious";
            case "salad" -> {
                System.out.println("green stuff");
                yield "healthy";
            }
            default -> "food";
        };

        System.out.println(newValue);
    }
}
