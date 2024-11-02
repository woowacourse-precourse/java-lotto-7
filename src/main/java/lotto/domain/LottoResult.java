package lotto.domain;

public class LottoResult {

    private final WinningState winningState;

    private LottoResult(int countMatchNumbers, boolean matchBonus) {
        this.winningState = WinningState.from(countMatchNumbers, matchBonus);
    }

    public static LottoResult createResult(int countMatchNumbers, boolean matchBonus) {
        if (countMatchNumbers == 5) {
            return new LottoResult(countMatchNumbers, matchBonus);
        }

        return new LottoResult(countMatchNumbers, false);
    }
}