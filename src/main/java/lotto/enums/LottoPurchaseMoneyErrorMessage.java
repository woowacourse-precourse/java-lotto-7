package lotto.enums;

public enum LottoPurchaseMoneyErrorMessage {
    NOT_POSITIVE("[ERROR] 구입금액은 0보다 커야합니다."),
    NOT_INTEGER("[ERROR] 구입금액은 숫자만 입력해야합니다."),
    NOT_MULTIPLE_OF_1000("[ERROR] 구입금액은 1000원 단위로 입력해야합니다."),
    OVER_1BILLION("[ERROR] 구입금액은 1,000,000,000원 이하여야합니다..");

    private final String message;

    LottoPurchaseMoneyErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
