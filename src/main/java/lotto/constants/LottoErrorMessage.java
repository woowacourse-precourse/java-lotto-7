package lotto.constants;

import static lotto.constants.ErrorConstants.*;

public enum LottoErrorMessage implements ErrorMessage {
    INVALID_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    NUMBER_OUT_OF_RANGE("로또 번호는 1 이상 45 이하여야 합니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return ERROR_PREFIX + message;
    }

}
