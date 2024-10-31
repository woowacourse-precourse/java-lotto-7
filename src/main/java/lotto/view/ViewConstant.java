package lotto.view;

public enum ViewConstant {

    INPUT_PURCHASE_FEE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    HOW_MANY_DID_YOU_PURCHASED("%d개를 구매했습니다."),
    LOTTERY_RESULT("당첨 통계\n"),
    DIVIDER("---");

    private final String message;

    ViewConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
