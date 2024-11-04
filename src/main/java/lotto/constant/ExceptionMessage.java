package lotto.constant;

public enum ExceptionMessage {

    EXCEPTION_MESSAGE_PREFIX("[ERROR]"),
    EXCEPTION_MESSAGE_DELIMITER(" "),

    INVALID_COMMON_EMPTY("공백은 입력할 수 없습니다."),

    INVALID_PRICE_CHAR("로또 구입 금액은 숫자로만 이루어져야 합니다."),
    INVALID_PRICE_MULTIPLE("로또 구입 금액은 1000의 배수여야 합니다."),
    INVALID_PRICE_ZERO("로또 구입 금액은 0원보다 커야 합니다."),

    INVALID_LOTTO_CHAR("로또 번호는 숫자 및 구분자인 ,만 입력 가능합니다."),
    INVALID_LOTTO_DELIMITER("로또 번호의 구분자인 ,는 숫자 사이에 하나씩만 존재할 수 있습니다."),
    INVALID_LOTTO_COUNT("로또 번호의 총 번호는 6개여야 합니다."),
    INVALID_LOTTO_RANGE("로또 번호의 각 번호는 1 이상 45 이하여야 합니다."),
    INVALID_LOTTO_DUPLICATE("로또 번호의 각 번호는 서로 중복될 수 없습니다."),

    INVALID_BONUS_CHAR("보너스 번호는 숫자만 입력 가능합니다."),
    INVALID_BONUS_RANGE("보너스 번호는 1 이상 45 이하여야 합니다."),
    INVALID_BONUS_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_MESSAGE_PREFIX.message + EXCEPTION_MESSAGE_DELIMITER.message + message;
    }

}
