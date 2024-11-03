package lotto.io;

public enum IOMessageTemplate {

    PRICE_NAVIGATE("구입금액을 입력해 주세요."),
    PURCHASED("%d개를 구매했습니다."),
    WINNING_NUMBERS_NAVIGATE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_NAVIGATE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTIC_BANNER("당첨 통계"),
    WINNING_STATISTIC_HORIZONTAL_RULE("---");

    private final String template;

    IOMessageTemplate(String template) {
        this.template = template;
    }

    public String format(Object... args) {
        return String.format(this.template, args);
    }
}
