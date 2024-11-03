package lotto.view;

public class OutPutView {

    private OutPutView() {
        throw new IllegalStateException("OutPutView is utility class");
    }

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

    public static void printNewLine() {
        System.out.println();
    }

    private static void printMessages(String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }
}
