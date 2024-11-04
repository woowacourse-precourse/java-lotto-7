package lotto.constants.errorType;

public enum WinningNumberErrorType {

    INVALID_WINNING_NUMBER_RANGE("[ERROR] 로또 당첨 번호는 1~45의 숫자만 입력해 주세요."),
    INVALID_WINNING_NUMBER_FORMAT("[ERROR] 지원하지 않는 당첨 번호 형식입니다."),
    INVALID_WINNING_NUMBER_DUPLICATE("[ERROR] 로또 번호에 중복된 번호가 존재합니다.");

    private final String message;

    WinningNumberErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
