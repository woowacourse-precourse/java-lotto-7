package lotto.constant;

import static lotto.constant.LottoInfo.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoInfo.LOTTO_PRICE;
import static lotto.constant.LottoInfo.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoInfo.MIN_LOTTO_NUMBER;

public enum ErrorMessage {
    NOT_A_NUMBER("숫자가 아닙니다."),
    NEGATIVE_MONEY("음수는 돈이 될 수 없습니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호가 중복됩니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다."),
    ZERO_LOTTO_MONEY("0원으로는 로또를 살 수 없습니다. 돈을 벌어오세요!"),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 " + LOTTO_NUMBER_COUNT + "개가 있어야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다."),
    NOT_DIVISIBLE_BY_LOTTO_PRICE("현재 로또 가격은 " + LOTTO_PRICE + "입니다. " + LOTTO_PRICE + "단위로 돈을 넣어주세요.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
