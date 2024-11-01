package lotto.view;

public enum ErrorMessage {
    NOT_A_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    NOT_A_UNIT_OF_1000("[ERROR] 1,000 단위의 금액으로만 구입 가능합니다."),
    NOT_SIX_NUMBERS("[ERROR] 로또 번호는 6개 입니다."),
    NOT_IN_RANGE("[ERROR] 로또는 1부터 45 사이의 숫자만 가능합니다."),
    NOT_DUPLICATE("[ERROR] 로또는 중복된 숫자가 나올 수 없습니다."),
    NOT_A_SINGLE("[ERROR] 보너스 번호는 1개입니다."),
    NOT_DUPLICATE_WITH_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
