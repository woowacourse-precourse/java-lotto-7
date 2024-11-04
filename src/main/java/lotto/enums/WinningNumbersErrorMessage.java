package lotto.enums;

public enum WinningNumbersErrorMessage {
    ONLY_NUMBER_AND_COMMAS("[ERROR] 로또 번호는 숫자와 쉼표(,)로 구분되어야 합니다."),
    INVALID_COMMA("[ERROR] 쉼표(,)로 시작하거나 끝나지 않아야 하며, 두 개의 쉼표가 붙어있으면 안됩니다."),
    INVALID_NUMBERS_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45사이여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다.");

    private final String message;

    WinningNumbersErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
