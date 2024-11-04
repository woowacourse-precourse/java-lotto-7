package lotto.view.message;

public enum SystemMessage {

    INPUT_PURCHASE_MONEY_AMOUNT("구입금액을 입력해주세요"),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요"),
    PRINT_STATICS("당첨 통계\n---");

    private String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
