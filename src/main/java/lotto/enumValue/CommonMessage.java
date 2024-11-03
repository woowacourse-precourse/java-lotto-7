package lotto.enumValue;

public enum CommonMessage {
    ERROR("[ERROR]"),
    FAIL("FAIL"),
    NEW_LINE("\n"),
    NUMBER("개" + CommonMessage.NEW_LINE.getMessange()),
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER(CommonMessage.NEW_LINE.getMessange() + "보너스 번호를 입력해 주세요."),
    SUCCESS_TEST_MONEY_TICKET("구매했습니다.");

    private final String messange;

    CommonMessage(String messange) {
        this.messange = messange;
    }

    public String getMessange() {
        return messange;
    }
}
