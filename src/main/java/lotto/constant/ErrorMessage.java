package lotto.constant;

public enum ErrorMessage {
    NOT_NUMBER_PURCHASE_AMOUNT("[ERROR] 구입금액에 숫자를 입력해 주세요!"),
    TOO_BIG_PURCHASE_AMOUNT("[ERROR] 구입금액이 너무 큽니다!"),
    LESS_THAN_THOUSAND_PURCHASE_AMOUNT("[ERROR] 구입금액에 1000 이상의 숫자를 입력해 주세요!"),
    NOT_PURCHASE_AMOUNT_FORMAT("[ERROR] 구입금액은 1000단위로 입력해 주세요!");

    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

}
