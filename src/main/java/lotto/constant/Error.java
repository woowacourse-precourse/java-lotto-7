package lotto.constant;

import static lotto.constant.LottoConstant.PRICE;

public enum Error {

    MIN_AMOUNT_PURCHASE("최소 한 개 이상 구매할 수 있습니다."),
    MAX_AMOUNT_PURCHASE("최대 천 개 까지 구매할 수 있습니다."),
    INVALID_UNIT_PURCHASE("반드시 " + PRICE + "원 단위로만 구매할 수 있습니다."),

    SIZE_LOTTO_NUMBERS("로또 번호는 반드시 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다."),
    RANGE_LOTTO_NUMBER("로또 번호는 반드시 1이상 45이하여야 합니다."),

    SIZE_WINNING_NUMBERS("당첨 번호는 6개여야 합니다."),
    DUPLICATED_WINNING_NUMBERS("당첨 번호는 중복될 수 없습니다."),
    RANGE_WINNING_NUMBER("당첨 번호는 반드시 1이상 45이하여야 합니다."),

    DUPLICATED_WINNING_BONUS_NUMBERS("당첨 번호와 보너스 번호는 겹칠 수 없습니다."),
    RANGE_BONUS_NUMBER("보너스 번호는 반드시 1이상 45이하여야 합니다.");

    private static final String PREFIX = "[ERROR]";

    private final String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + " " + message;
    }
}
