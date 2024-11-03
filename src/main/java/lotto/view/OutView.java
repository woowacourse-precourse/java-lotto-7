package lotto.view;

public class OutView {



    public static void printMessageWithNewLine(String message) {
        printMessage(message);
        printNewLine();
    }

    public static void printMessagesWithNewLine(String... messages) {
        printMessages(messages);
        printNewLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printMessages(String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    private static void printNewLine() {
        System.out.println();
    }
}
