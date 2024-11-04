package message;

public enum ErrorMessage {

    IS_EMPTY("[ERROR] 빈 문자가 입력되었습니다."),
    CANNOT_BUY_LOTTO("[ERROR] 입력한 금액이 1,000원 단위로 나누어 떨어지지 않습니다."),
    CONTAINS_LETTER("[ERROR] 입력값에 숫자가 아닌 문자가 포함되어 있습니다."),
    NUM_OF_NUMBERS("[ERROR] 로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    DUPLICATE_WINNING_BONUS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    LOWER_THAN_ZERO("[ERROR] 입력한 금액이 0원보다 작습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
