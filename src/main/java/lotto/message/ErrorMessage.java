package lotto.message;

public enum ErrorMessage {

    INVALID_NUMBER_FORMAT("[ERROR] 숫자 형식으로 입력해야 합니다."),
    INVALID_PRICE_MULTIPLE("[ERROR] 금액은 1000원 단위로 입력해야 합니다."),
    NEGATIVE_PRICE_VALUE("[ERROR] 금액은 양의 정수로 입력해야 합니다."),
    INVALID_INPUT_FORMAT("[ERROR] 숫자는 공백 없이 쉼표(,)로 구분해 입력해야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 숫자는 1 이상 45 이하의 범위여야 합니다."),
    INVALID_NUMBER_COUNT("[ERROR] 총 6개의 숫자를 입력해야 합니다."),
    DUPLICATE_NUMBER_PRESENT("[ERROR] 중복된 숫자는 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public void printError() {
        System.out.println(message);
    }

    public String getErrorMessage() {
        return this.message;
    }

}
