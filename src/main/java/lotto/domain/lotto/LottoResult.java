package lotto.domain.lotto;

import lotto.domain.winner.ResultState;

public class LottoResult {

    private final ResultState resultState;

    private LottoResult(int countMatchNumbers, boolean matchBonus) {
        this.resultState = ResultState.from(countMatchNumbers, matchBonus);
    }

    public static LottoResult createResult(int countMatchNumbers, boolean matchBonus) {
        if (countMatchNumbers == 5) {
            return new LottoResult(countMatchNumbers, matchBonus);
        }

        return new LottoResult(countMatchNumbers, false);
    }

    public boolean isWinner() {
        return resultState.isWinner();
    }

    public ResultState getWinningState() {
        return resultState;
    }
}