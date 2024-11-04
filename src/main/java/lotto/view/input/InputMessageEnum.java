package lotto.view.input;

public enum InputMessageEnum {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ERROR_PREFIX("[ERROR] "),
    INVALID_NUMBER_ERROR(ERROR_PREFIX.message + "로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER_ERROR(ERROR_PREFIX.message + "로또 번호에 중복된 숫자가 있습니다."),
    INVALID_COUNT_ERROR(ERROR_PREFIX.message + "로또 번호는 6개여야 합니다."),
    DUPLICATE_BONUS_NUMBER_ERROR(ERROR_PREFIX.message + "보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_AMOUNT_ERROR(ERROR_PREFIX.message + "구입금액은 1,000원 단위의 양수여야 합니다.");

    private final String message;

    InputMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}