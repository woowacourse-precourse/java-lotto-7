package lotto.view.output.infrastructure;

import lotto.view.output.domain.ResultMessage;

public class ErrorOutput {
    public static void view(IllegalArgumentException illegalArgumentException) {
        ResultMessage.ERROR_MESSAGE.print(illegalArgumentException.getMessage());
    }
}
