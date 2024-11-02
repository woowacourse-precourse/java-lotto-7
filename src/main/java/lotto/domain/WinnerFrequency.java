package lotto.domain;

public class WinnerFrequency {

    private final WinningState winningState;
    private final int count;

    public WinnerFrequency(WinningState winningState, int count) {
        this.winningState = winningState;
        this.count = count;
    }

    public String getMessage() {
        return winningState.provideMessage(count);
    }
}