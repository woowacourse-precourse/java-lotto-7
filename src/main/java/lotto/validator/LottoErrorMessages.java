package lotto.validator;

import static lotto.constants.LottoConstants.LINE_SPACE;
import static lotto.constants.LottoConstants.RANDOM_MIN;
import static lotto.constants.LottoConstants.RANDOM_MAX;
import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_THRESHOLD;
import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_UNIT;
import static lotto.constants.LottoConstants.ERROR_MESSAGE_BEGINNING;

public enum LottoErrorMessages {
    MUST_BE_TARGET_LENGTH("%s %s 번호는 %d개이어야 합니다."),
    MUST_BE_NUMBER("%s %s은(는) 숫자 형식이어야 합니다."),
    MUST_BE_UNIQUE("%s 로또 번호가 중복되었습니다."),
    MUST_BE_NO_SPACE("%s %s에 공백을 허용하지 않습니다."),
    MUST_BE_RANGE("%s 로또 번호는 " + RANDOM_MIN + " ~ " + RANDOM_MAX + " 사이 숫자이어야 합니다."),
    MUST_BE_OVER_THRESHOLD("%s 구입 금액은 " + PURCHASE_AMOUNT_THRESHOLD + "원 이상이어야 합니다."),
    MUST_BE_UNIT("%s 구입 금액은 " + PURCHASE_AMOUNT_UNIT + "원 단위이어야 합니다.");

    private final String message;

    LottoErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(LINE_SPACE + message, ERROR_MESSAGE_BEGINNING);
    }

    public String getMessage(String input) {
        return String.format(LINE_SPACE + message, ERROR_MESSAGE_BEGINNING, input);
    }

    public String getMessage(String type, int length) {
        return String.format(LINE_SPACE + message, ERROR_MESSAGE_BEGINNING, type, length);
    }
}
