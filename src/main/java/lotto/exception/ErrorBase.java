package lotto.exception;

import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;
import static lotto.util.LottoConstants.LOTTO_PURCHASE_AMOUNT;

public enum ErrorBase {
    PURCHASE_AMOUNT_BLANK("[ERROR] 구입 금액을 입력해주세요."),
    PURCHASE_AMOUNT_NON_NUMERIC("[ERROR] 구입 금액은 숫자여야 합니다."),
    PURCHASE_AMOUNT_INVALID("[ERROR] 구입 금액은 양수여야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE("[ERROR] 구입 금액은 " + LOTTO_PURCHASE_AMOUNT + "원 단위여야 합니다."),

    BLANK_WINNING_NUMBERS("[ERROR] 당첨 번호를 입력해주세요."),
    WINNING_NUMBERS_NON_NUMERIC("[ERROR] 당첨 번호는 숫자여야 합니다."),

    BONUS_NUMBER_BLANK("[ERROR] 보너스 번호를 입력해주세요."),
    BONUS_NUMBER_NON_NUMERIC("[ERROR] 보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨번호와 중복된 숫자가 있을 수 없습니다."),

    LOTTO_NUMBERS_INVALID_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("[ERROR] 로또 번호는 " + LOTTO_NUMBER_MIN + "부터 " + LOTTO_NUMBER_MAX + " 사이의 숫자여야 합니다.");


    private final String message;

    ErrorBase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
