package lotto.constant;

public enum ExceptionMessageConstants {

    DUPLICATE_LOTTO_NUMBER_ERROR("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE_ERROR("로또 번호는 1~45사이의 숫자 입니다."),
    EXACT_CHANGE_NOT_POSSIBLE_ERROR("금액은 1,000원으로 나누어 떨어져아 합니다."),
    PRICE_NUMBER_FORMAT_ERROR("금액은 숫자로 입력해주세요."),
    LOTTO_NUMBER_FORMAT_ERROR("당첨번호는 숫자로 입력해주세요")
    ;

    private final String message;

    ExceptionMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
