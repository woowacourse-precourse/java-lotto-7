package lotto.utility;

public enum ExceptionEnum {
    CANNOT_INCLUDE_ZERO("[ERROR] 로또 번호에는 0이 포함될 수 없습니다."),
    CANNOT_DRAW_DUPLICATE_NUMBER("[ERROR] 중복된 번호는 뽑으실 수 없습니다."),
    CANNOT_UNDER_ZERO("[ERROR] 0 이하의 수는 입력하실 수 없습니다."),
    UNDIVIDABLE_BY_THOUSAND("[ERROR]: 1,000으로 나누어 떨어지지 않는 수는 입력하실 수 없습니다."),
    MUST_SIX("[ERROR] 당첨 번호는 6개여야 합니다."),
    CANNOT_OVER_FOURTY_SIX("[ERROR] 최대 45까지만 입력 가능합니다."),
    DUPLICATE_WINNING_AND_BONUS("[ERROR] 당첨 번호에 포함되는 수는 보너스 번호로 입력할 수 없습니다."),
    INVALID_NUMBER("[ERROR] 유효하지 않은 숫자를 입력하셨습니다.");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}