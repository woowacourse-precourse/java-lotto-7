package view;

public class OutputView {

    public static void printInputMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
