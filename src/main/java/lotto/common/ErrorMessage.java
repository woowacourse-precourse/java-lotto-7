package lotto.common;

import static lotto.model.Lotto.getLottoPrice;
import static lotto.model.Lotto.getLottoSize;
import static lotto.model.Lotto.getMaxNumber;
import static lotto.model.Lotto.getMinNumber;

public enum ErrorMessage {

    INPUT_MONEY_IS_DIGIT("[ERROR] 구입 금액은 양수입니다."),
    LOTTO_NUMBERS_MUST_SIX(String.format("[ERROR] 로또 번호는 %d개여리야 합니다.", getLottoSize())),
    LOTTO_NUMBER_RANGE(String.format("[ERROR] 로또 번호의 숫자 범위는 %d~%d까지입니다.", getMinNumber(), getMaxNumber())),
    LOTTO_NUMBER_DISTINCT("[ERROR] 로또 번호는 중복이 없어야합니다."),
    INPUT_MONEY_IS_MULTIPLE_1000(String.format("[ERROR] 구입 금액은 %,d원 단위로 입력받습니다.", getLottoPrice())),
    INPUT_LOTTO_NUMBER_IS_NOT_NEGATIVE_INTEGER("[ERROR] 입력이 0이상인 정수여야합니다."),
    INPUT_IS_NOT_BLANK("[ERROR] 값을 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
