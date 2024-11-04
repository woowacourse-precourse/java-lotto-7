package lotto;

enum InputPrompt {
    PURCHASE("구입 금액을 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
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
    LOTTO_ISSUE("\n%d개를 구매했습니다."),
    WINNING_DETAIL_HEAD("\n당첨 통계\n---"),

    FIRST("6개 일치 (2,000,000,000원) - %d개"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD("5개 일치 (1,500,000원) - %d개"),
    FOURTH("4개 일치 (50,000원) - %d개"),
    FIFTH("3개 일치 (5,000원) - %d개"),

    PROFIT_RATE("총 수익률은 %s%%입니다.");

    private final String defaultPrint;

    OutputPrompt(String print) {
        this.defaultPrint = print;
    }

    public String getDefaultPrint() {
        return defaultPrint;
    }

    public String print(int value) {
        return String.format(defaultPrint, value);
    }

    public String print(String value) {
        return String.format(defaultPrint, value);
    }
}