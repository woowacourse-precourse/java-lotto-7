package lotto.view;

import lotto.constants.InputError;

public class ErrorPrinter {
    public static void errorPrint(InputError message) {
//        System.out.println(message.getMessage());
        try {
            throw new IllegalArgumentException(message.getMessage());
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
