package lotto.constant;

public enum MatchMessage {
    MessageThree("3개 일치 (5,000원)"),
    MessageFour("4개 일치 (50,000원)"),
    MessageFive("5개 일치 (1,500,000원)"),
    MessageFiveWithAddition("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MessageSix("6개 일치 (2,000,000,000원)");

    private final String Message;

    MatchMessage(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }
}
