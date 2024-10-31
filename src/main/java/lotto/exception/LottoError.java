package lotto.exception;

public enum LottoError implements ApplicationError {

    NUMBER_OUT_OF_RANGE("로또 번호는 1부터 46사이여야 합니다."),
    NUMBER_DUPLICATED("로또 번호는 중복되지 않아야 합니다."),
    NUMBERS_WRONG_SIZE("로또 번호는 6개여야 합니다."),
    ;

    private final String message;

    LottoError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
