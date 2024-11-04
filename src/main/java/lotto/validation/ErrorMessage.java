package lotto.validation;

public enum ErrorMessage {
    INVALID_AMOUNT("[ERROR] 가격은 1000원 단위로 입력 가능합니다."),
    INVALID_INPUT("[ERROR] 문자열은 입력 불가합니다."),
    INVALID_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 숫자가 중복되면 안됩니다."),
    DUPLICATE_WITH_WIN_NUMBER("[ERROR] 당첨 번호와 보너스 번호가 중복되면 안됩니다."),
    NEGATIVE_OR_ZERO("[ERROR] 0 이하의 수는 입력할 수 없습니다."),
    OUT_OF_RANGE("[ERROR] 1 ~ 45 중에서 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
