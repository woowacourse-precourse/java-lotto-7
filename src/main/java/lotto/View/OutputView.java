package lotto.View;

import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessages(List<String> messages) {
        for (String message : messages) {
            printMessage(message);
        }
    }

    public static void printMessage() {
        System.out.println();
    }

}
