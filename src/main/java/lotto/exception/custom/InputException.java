package lotto.exception.custom;

public enum InputException implements CustomException {

    INVALID_INTEGER("양수를 입력해주세요"),
    INVALID_DELIMITER("유효하지 않은 구분 기호 입니다."),
    INVALID_INPUT("유요하지 않은 입력값입니다.")
    ;

    private final String message;

    InputException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
