package lotto.vo;

public enum OutputMessage {
    PRICE_INPUT("구입금액을 입력해 주세요."),
    TOTAL_LOTTO_QUANTITY("%d개를 구매했습니다."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int keyword) {
        return String.format(message, keyword);
    }
}
