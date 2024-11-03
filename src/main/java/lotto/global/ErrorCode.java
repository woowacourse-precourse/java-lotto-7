package lotto.global;

public enum ErrorCode {

    DIVISION_ERROR("[ERROR] 1000의 배수만 입력 해 주세요."),
    MINUS_NUMBER_ERROR("[ERROR] 양수를 입력 해 주세요"),
    NUMBER_FORMAT_ERROR("[ERROR] 숫자를 입력 해 주세요"),
    HAS_NUMBER_EXIST("[ERROR] 중복되는 수가 있습니다"),
    NUMBER_NOT_SIX("[ERROR] 로또 번호는 6개여야 합니다."),
    BONUS_NUMBER_ZERO_AND_LESS("[ERROR] 0보다 커야합니다."),
    WIN_NOT_EXIST_NUMBER("[ERROR] 당첨 번호에 없는 번호여야 합니다.");


    private final String message;

    public String getMessage() {
        return message;
    }

    ErrorCode(String message) {
        this.message = message;
    }
}
