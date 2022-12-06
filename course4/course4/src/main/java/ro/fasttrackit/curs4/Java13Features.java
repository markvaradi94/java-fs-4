package ro.fasttrackit.curs4;

public class Java13Features {
    public static void main(String[] args) {
        textBlocks();
    }

    private static void textBlocks() {
        String jsonMultiline = "{" +
                "'name':'Ana'," +
                "'age':22" +
                "}";

        String json = """
                {
                    'name':'Ana',
                    'age':22
                }
                """;

        System.out.println(jsonMultiline);
        System.out.println(json);
    }
}
