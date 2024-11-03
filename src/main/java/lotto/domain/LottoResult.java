package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoResult {

    FIFTH_PLACE(5, 3, 5_000, Arrays.asList(true, false)),
    FOURTH_PLACE(4, 4, 50_000, Arrays.asList(true, false)),
    THIRD_PLACE(3, 5, 1_500_000, Arrays.asList(false)),
    SECOND_PLACE(2, 5, 30_000_000, Arrays.asList(true)),
    FIRST_PLACE(1, 6, 2_000_000_000, Arrays.asList(true, false));

    private final int rank;
    private final int matchingCount;
    private final int winningAmount;
    private final List<Boolean> doesBonusNumberMatch;

    LottoResult(int rank, int matchingCount, int winningAmount, List<Boolean> doesBonusNumberMatch) {
        this.rank = rank;
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
        this.doesBonusNumberMatch = doesBonusNumberMatch;
    }

    public static LottoResult getLottoResult(int matchingCount, boolean doesBonusNumberMatch) {
        for (LottoResult result : values()) {
            if (doesResultMatch(matchingCount, doesBonusNumberMatch, result)) {
                return result;
            }
        }
        throw new IllegalArgumentException("[ERROR] 매칭되는 로또 결과가 없습니다.");
    }

    private static boolean doesResultMatch(int matchingCount, boolean doesBonusNumberMatch, LottoResult result) {
        return result.matchingCount == matchingCount && result.doesBonusNumberMatch.contains(doesBonusNumberMatch);
    }

    public int getRank() {
        return rank;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
