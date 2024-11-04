package lotto.exception;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

public enum LottoErrorMessage {
    INVALID_INPUT("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요."),
    EMPTY_INPUT("[ERROR] 입력이 비어있습니다."),
    NOT_A_NUMBER_INPUT("[ERROR] 숫자를 입력해주세요"),
    LOTTO_MONEY_TOO_LOW(String.format("[ERROR] 로또 금액은 %,d 이상의 값을 입력해주세요.", LOTTO_PRICE)),
    LOTTO_MONEY_INVALID_UNIT(String.format("[ERROR] 로또 금액은 %,d 단위로 입력해주세요.", LOTTO_PRICE)),
    LOTTO_NUMBER_COUNT_INVALID("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1~45 사이의 자연수 입니다."),
    BONUS_NUMBER_DUPLICATE_WITH_WINNING_NUMBER("당첨 번호와 중복되는 보너스 번호입니다.");

    public final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }
}