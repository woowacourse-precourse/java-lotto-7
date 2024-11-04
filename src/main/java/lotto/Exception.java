package lotto;

public enum Exception {
    IS_NOT_1000_UNIT("[ERROR] 로또 구입은 1000원 단위로 할 수 있습니다."),
    DONT_NOT_ZERO("[ERROR] 로또를 하나 이상 구매해주세요"),
    SIX_WINNING_NUMBER("[ERROR] 당첨 번호의 개수는 6개입니다"),
    NUMBER_RANGE("[ERROR] 1에서 45사이의 번호를 입력하십시오."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 중복되지 않게 당첨 번호를 입력하세요."),
    DUPLICATE_BONUS_WINNING("[ERROR] 당첨번호와 중복된 숫자가 있습니다"),
    DONT_ENTER_STRING("[ERROR] 구입 금액을 올바르게 입력하십시오."),
    DUPLICATE_NUMBER_LOTTO("[ERROR] 로또에 중복된 숫자가 있습니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
