package lotto.view;

public enum Outputs {
    SPACE(" "),
    MONEY_REQUEST("구입금액을 입력해 주세요."),
    LOTTO_BOUGHT("개를 구매했습니다.");

    final String message;

    Outputs(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
