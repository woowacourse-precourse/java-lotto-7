package lotto.common;

public enum ErrorMessage {
    // TODO: 에러 세부화해서 클래스 추출?
    EMPTY_INPUT("[ERROR] 입력이 비어있습니다."),
    INTEGER_RANGE_EXCESS("[ERROR] 입력 숫자가 가능 범위를 초과합니다."),
    NOT_NUMBER_OR_RANGE_EXCESS("[ERROR] 숫자 이외의 입력이 존재하거나 범위를 초과합니다."),
    NEGATIVE_NUMBER("[ERROR] 음수를 입력할 수 없습니다."),
    MULTIPLES_OF_THOUSAND("[ERROR] 입력 금액의 1000의 배수여야 합니다."),
    MAIN_NUMBERS_COUNT("[ERROR] 입력 당첨 번호가 6개가 아닙니다."),
    WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1에서 45 사이 정수여야 합니다."),
    DUPLICATE_EXIST("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    BONUS_DUPLICATE_EXIST("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
