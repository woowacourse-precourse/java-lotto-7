package lotto.domain.winner;

import lotto.domain.lotto.ResultState;

public class WinnerFrequency {

    private final ResultState resultState;
    private final int count;

    public WinnerFrequency(ResultState resultState, int count) {
        this.resultState = resultState;
        this.count = count;
    }

    public String getMessage() {
        return resultState.provideMessage(count);
    }
}