package lotto.domain;

import java.util.List;

public class MatchResult {

    private final int matchCount;
    private final boolean matchBonus;

    private MatchResult(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static MatchResult of(Lotto lotto, LottoDraw lottoDraw) {
        int matchCount = getMatchCount(lotto.getNumbers(), lottoDraw.getWinningLotto().getNumbers());
        boolean matchBonus = lotto.getNumbers().contains(lottoDraw.getBonusNumber());
        return new MatchResult(matchCount, matchBonus);
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
