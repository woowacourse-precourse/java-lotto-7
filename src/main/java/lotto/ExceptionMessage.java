package lotto;

public enum ExceptionMessage {
    INPUT_EMPTY("빈 문자열이 입력되었습니다."),
    NUM_NOT_NUM("입력된 값이 숫자가 아닙니다."),
    NUM_NOT_IN_RANGE("입력된 값이 1~45 범위 바깥입니다."),
    PURCHASE_NOT_ROUND_THOUSAND("입력된 구입 금액이 천 단위가 아닙니다."),
    PURCHASE_UNDER_THOUSAND("입력된 구입 금액이 천원 이하면 로또를 구매할 수 없습니다."),
    WINNING_NOT_SIX("입력된 당첨 번호의 개수가 6개가 아닙니다."),
    WINNING_DUPLICATED("입력된 당첨 번호 중 중복된 번호가 존재합니다."),
    BONUS_DUPLICATED("입력된 보너스 번호가 당첨 번호 중 하나와 중복입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
