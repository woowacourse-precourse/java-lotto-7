package lotto.service;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public enum WinningResult {

    THREE("3", "3개", 5000),
    FOUR("4", "4개", 50_000),
    FIVE("5", "5개", 1_500_000),
    BONUS("5Bonus", "5개 일치, 보너스 볼", 30_000_000),
    SIX("6", "6개", 2_000_000_000);

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();
    private static final String UNIT = "원";
    private static final String SAME = " 일치";
    private static final String TEMPLATE = "%s" + SAME + " (%s" + UNIT + ") - %d개";
    private static final String MATCH_ERROR = "지정되지 않은 등수가 있습니다: ";
    private static final Map<String, WinningResult> MATCH_WINNING_RESULT = new HashMap<>();

    static {
        for (WinningResult winningResult : WinningResult.values()) {
            MATCH_WINNING_RESULT.put(winningResult.match, winningResult);
        }
    }

    private final String match;
    private final String placeMessage;
    private final int prizeAmount;

    WinningResult(final String match, final String placeMessage, final int prizeAmount) {
        this.match = match;
        this.placeMessage = placeMessage;
        this.prizeAmount = prizeAmount;
    }

    public static WinningResult fromMatchCount(final String matchCount) {
        WinningResult winningResult = MATCH_WINNING_RESULT.get(matchCount);
        if (winningResult == null) {
            throw new IllegalArgumentException(MATCH_ERROR);
        }
        return winningResult;
    }

    public String makeSentence(final int num) {
        String amount = numberFormat.format(prizeAmount);
        return String.format(TEMPLATE, placeMessage, amount, num);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
