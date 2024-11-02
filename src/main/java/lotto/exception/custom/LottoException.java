package lotto.exception.custom;

public enum LottoException implements CustomException {

    DUPLICATED_ELEMENTS("로또 번호가 중복되었습니다."),
    ;

    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
