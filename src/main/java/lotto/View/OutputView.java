package lotto.View;

import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(List<String> messages) {
        for (String message : messages) {
            printMessage(message);
        }
    }
}
