package lotto.enums;

public enum OutputViewEnum {
    PURCHASE_AMOUNT_INPUT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    ERROR_MESSAGE_FORMAT("[ERROR] ");

    private final String message;

    OutputViewEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}