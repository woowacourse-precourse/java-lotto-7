package lotto.domain.lotto;

public class LottoResult {

    private final ResultState resultState;

    public LottoResult(int countMatchNumbers, boolean matchBonus) {
        this.resultState = ResultState.from(countMatchNumbers, matchBonus);
    }

    public boolean isWinner() {
        return resultState.isWinner();
    }

    public ResultState getState() {
        return resultState;
    }
}