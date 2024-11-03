package lotto.enums;

public enum ErrorMessage {
    INVALID_NUMBER_COUNT ("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE ("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER ("[ERROR] 중복된 번호는 허용되지 않습니다."),
    INVALID_MONEY_INPUT_1000 ("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    INVALID_MONEY_INPUT ("[ERROR] 구입 금액은 정수 및 1000원 단위여야 합니다."),
    INVALID_PARAM_INPUT ("[ERROR] 띄어쓰기 혹은 구분자 입력 이상이 존재합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
