package lotto.exceptionHandler;

import lotto.service.exception.LottoException;

public class ExceptionHandler {

    public static void handle(Runnable action) {
        try {
            action.run();
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            handle(action);
        }
    }
}
