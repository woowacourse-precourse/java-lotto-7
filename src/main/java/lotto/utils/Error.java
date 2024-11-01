package lotto.utils;

public enum Error {
    PURCHASE_AMOUNT_NOT_A_NUMBER("[ERROR] 구매 금액은 숫자 형식이어야 합니다."),
    WINNING_NUMBERS_NOT_A_NUMBER("[ERROR] 당첨 번호는 숫자 형식이어야 합니다."),
    BONUS_NUMBER_NOT_A_NUMBER("[ERROR] 보너스 번호는 숫자 형식이어야 합니다.");


    private final String description;

    Error(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
