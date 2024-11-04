package lotto.presentation.view;

import static lotto.constant.Error.TYPE_MISMATCH_INTEGER;
import static lotto.constant.Error.UNKNOWN;

public class ExceptionView {

    public static void render(Exception exception) {
        if (exception instanceof NumberFormatException) {
            System.out.println(TYPE_MISMATCH_INTEGER);
            return;
        }

        if (exception instanceof IllegalArgumentException) {
            System.out.println(exception.getMessage());
            return;
        }

        System.err.println(UNKNOWN);
    }
}
