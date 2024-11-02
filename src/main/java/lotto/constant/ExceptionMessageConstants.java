package lotto.constant;

public enum ExceptionMessageConstants {

    DUPLICATE_LOTTO_NUMBER_ERROR("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE_ERROR("로또 번호는 1~45사이의 숫자 입니다."),
    ;

    private final String message;

    ExceptionMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
