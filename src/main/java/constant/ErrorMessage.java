package constant;

public enum ErrorMessage {
    NOT_NUMBER_CHANGE("[ERROR] 잘못된 값을 입력해 숫자로 변환할 수 없습니다."),
    NOT_DIVIDE_AMOUNT("[ERROR] 적으신 금액의 액수가 로또 가격의 상수배여야 합니다."),

    NOT_NEGATIVE_NUMBER("[ERROR] 음수가 될 수 없습니다."),

    NOT_DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),

    NOT_FIT_LOTTO_NUMBER_SCOPE("[ERROR] 로또 번호 범위에 맞지 않습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String show() {
        return errorMessage;
    }
}
