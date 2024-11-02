package lotto.infrastructure.constant;

public final class PromptMessage {
    public static final String COST_INPUT = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";
    public static final String RESULT_OUTPUT = "\n당첨통계\n---";
    public static String PURCHASE_COUNT_OUTPUT(int count) {
        return String.format("%d개를 구매했습니다.", count);
    }
    public static String REVENUE_RATE_OUTPUT(String rate) {
        return String.format("총 수익률은 %s입니다.", rate);
    }
}
