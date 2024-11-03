package lotto.constant;

public enum PrintText {
    REQUIRE_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUIRE_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUIRE_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT_TITLE("당첨 통계");


    private final String text;

    PrintText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
