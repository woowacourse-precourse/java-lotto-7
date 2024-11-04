package lotto.io.request;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.util.ExceptionMessages;

public record bonusNumberRequest(Lotto lotto, String number) {

    private static final String NUMBER_PATTERN = "\\d+";

    public bonusNumberRequest {
        validateEmpty(number);
        validateNumber(number);
        WinningLotto winningLotto = WinningLotto.from(lotto, Integer.parseInt(number));
    }

    private void validateEmpty(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_INPUT.getMessage());
        }
    }

    private void validateNumber(String number) {
        if (!number.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CHARACTER.getMessage());
        }
    }
}
