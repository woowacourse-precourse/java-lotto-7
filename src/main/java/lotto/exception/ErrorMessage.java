package lotto.exception;

import static java.lang.String.format;
import static lotto.constant.LottoGameRule.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameRule.MIN_LOTTO_NUMBER;

public enum ErrorMessage {
    // 입력
    INPUT_EMPTY_ERROR("빈 입력입니다." ),
    END_WITH_DELIMITER("입력은 구분자(%s)로 끝날 수 없습니다." ),

    // 구입 금액
    MONEY_NOT_DIVISIBLE("구입 금액은 %d원으로 나누어 떨어져야 합니다." ),
    MONEY_NOT_NUMBER("구입 금액은 int 범위 내의 숫자여야 합니다." ),
    MONEY_OUT_OF_RANGE("구입 금액은 %d이상의 정수여야 합니다." ),

    // 당첨 번호
    WINNING_NUMBER_NOT_DIGIT("당첨 번호는 숫자여야 합니다." ),
    WINNING_NUMBER_OUT_OF_RANGE(
            format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue())),
    DUPLICATED_NUMBER("중복된 번호가 있습니다." ),
    NUMBERS_SIZE_ERROR("로또 번호는 %d개여야 합니다." ),

    // 보너스 번호
    BONUS_NUMBER_NOT_DIGIT("보너스 번호는 숫자여야 합니다." ),
    BONUS_NUMBER_DUPLICATE("당첨 번호와 중복된 번호입니다." ),
    BONUS_NUMBER_OUT_OF_RANGE(
            format("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue()));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
