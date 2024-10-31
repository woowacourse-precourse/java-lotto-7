package lotto.view;

import lotto.constants.InputError;

public class ErrorPrinter {
    public static void errorPrint(InputError message) {
        System.out.println(message.getMessage());
    }
}
