package lotto.view;

public enum Outputs {
    SPACE(" "),
    MONEY_REQUEST("구입금액을 입력해 주세요."),
    TICKETS_BOUGHT("개를 구매했습니다."),
    LOTTO_REQUEST("당첨 번호를 입력해 주세요."),
    BONUS_REQUEST("보너스 번호를 입력해 주세요.");

    final String message;

    Outputs(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
