package lotto.model;

import java.util.Set;

public class Input {
    private final int buy;
    private final Set<String> winningNum;

    public Input(int buy, Set<String> winningNum) {
        this.buy = buy;
        this.winningNum = winningNum;
    }

    public int getBuy() {
        return buy;
    }

    public Set<String> getWinningNum() {
        return winningNum;
    }
}