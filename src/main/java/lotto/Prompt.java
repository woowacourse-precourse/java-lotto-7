package lotto;

enum InputPrompt {
    PURCHASE("구입 금액을 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요.");

    private final String guide;

    InputPrompt(String guide) {
        this.guide = guide;
    }

    public String getGuide() {
        return guide;
    }
}

enum OutputPrompt {
    LOTTO_ISSUE("%d개를 구매했습니다."),

    LOTTO_WINNING_3("3개 일치 (5,000원) - %d개"),
    LOTTO_WINNING_4("4개 일치 (50,000원) - %d개"),
    LOTTO_WINNING_5("5개 일치 (,1500,000원) - %d개"),
    LOTTO_WINNING_BONUS("5개 일치 (30,000,000원) - %d개"),
    LOTTO_WINNING_6("6개 일치 (2,000,000,000원) - %d개"),

    PROFIT_RATE("총 수익률은 %s%%이다.");

    private final String defaultPrint;

    OutputPrompt(String print) {
        this.defaultPrint = print;
    }

    public String print(int value) {
        return String.format(defaultPrint, value);
    }

    public String print(String value) {
        return String.format(defaultPrint, value);
    }
}