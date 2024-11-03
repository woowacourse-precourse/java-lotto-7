package lotto.view;

import lotto.constants.InputError;

public class ErrorPrinter {
    public static void errorPrint(InputError message) {
        try {
            throw new IllegalArgumentException(message.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
