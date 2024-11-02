package lotto.view;

public enum ExceptionMessages {
    ERROR("[ERROR] "),
    OUT_OF_INTEGER_RANGE("구매 금액은 정수 범위여야 합니다."),
    NOT_MULTIPLE_OF_UNIT_PRICE("구매 금액은 개당 금액의 배수여야 합니다."),
    ;

    private final String messages;

    ExceptionMessages(String messages) {
        this.messages = messages;
    }

    public String getMessages() {
        return ERROR + messages;
    }
}
