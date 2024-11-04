package lotto.message;

public enum Message {
    INPUT_PURCHASE_MONEY("구입 금액을 입력해 주세요."),
    INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_AMOUNT_MESSAGE("개를 구매했습니다."),
    WIN_STAT_MESSAGE("당첨 통계\n---"),
    MATCH_3("3개 일치 (5,000원) - %d개"),
    MATCH_4("4개 일치 (50,000원) - %d개"),
    MATCH_5("5개 일치 (1,500,000원) - %d개"),
    MATCH_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCH_6("6개 일치 (2,000,000,000원) - %d개");;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void print() {
        System.out.print(message);
    }

    public void println() {
        System.out.println(message);
    }
    public void printFormatted(Long count) {
        System.out.printf(message + "\n", count);
    }
}
