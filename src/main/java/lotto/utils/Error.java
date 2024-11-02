package lotto.utils;

public enum Error {
    PURCHASE_AMOUNT_NOT_A_NUMBER("[ERROR] 구매 금액은 숫자 형식이어야 합니다."),
    WINNING_NUMBERS_NOT_A_NUMBER("[ERROR] 당첨 번호는 숫자 형식이어야 합니다."),
    BONUS_NUMBER_NOT_A_NUMBER("[ERROR] 보너스 번호는 숫자 형식이어야 합니다."),
    NOT_SIX_LOTTO_NUMBERS("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_SIX_WINNING_NUMBERS("[ERROR] 당첨 번호는 6개여야 합니다."),
    DUPLICATED_WINNING_NUMBERS("[ERROR] 당첨 번호는 중복되지 않아야 합니다."),
    WINNING_NUMBERS_OUT_OF_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다.");
    private final String description;

    Error(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
