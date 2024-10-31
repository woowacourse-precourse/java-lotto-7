package lotto.constant;

public enum PrintText {
    REQUIRE_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ;


    private final String text;

    PrintText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
