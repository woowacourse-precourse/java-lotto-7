package lotto.view;

public enum Outputs {

    SPACE(" "),
    MONEY_REQUEST("구입금액을 입력해 주세요."),
    TICKETS_BOUGHT("개를 구매했습니다."),
    LOTTO_REQUEST("\n당첨 번호를 입력해 주세요."),
    BONUS_REQUEST("\n보너스 번호를 입력해 주세요."),

    STATISTICS("\n당첨 통계\n---"),
    MATCH_COUNT("개 일치 ("),
    MATCH_COUNT_WITH_BONUS("개 일치, 보너스 볼 일치 ("),
    WON("원"),
    PARENTHESIS_HYPHEN(") - "),
    NUMBER("개"),

    TOTAL_REVENUE_PERCENT("총 수익률은 "),
    PERCENT("%"),
    DESU("입니다.");

    final String message;

    Outputs(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
