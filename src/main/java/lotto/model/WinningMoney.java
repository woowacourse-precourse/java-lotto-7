package lotto.model;

import java.util.List;

import lotto.Rank;

public class WinningMoney {

    private final List<Rank> result;
    private int totalReward = 0;

    public WinningMoney(List<Rank> result) {
        this.result = result;
        calculate();
    }

    private void calculate() {
        for (Rank rank : result) {
            totalReward += rank.getReward();
        }
    }

    public int getTotalReward() {
        return totalReward;
    }
}
