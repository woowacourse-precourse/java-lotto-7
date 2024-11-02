package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int amount;
    private double rateOfReturn;
    private List<Lotto> lottos;
    private List<Rank> winnings;

    public User(int amount) {
        this.amount = amount;
        this.rateOfReturn = 0.0;
        this.lottos = new ArrayList<>();
        this.winnings = new ArrayList<>();
    }

    public int getPurchaseCount() {
        return this.amount / 1_000;
    }

    public void updateLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void addWinning(Rank rank) {
        this.winnings.add(rank);
    }

    public List<Rank> getWinningLottos() {
        return this.winnings;
    }

    public void updateRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public int getAmount() {
        return this.amount;
    }

    public double getRateOfReturn() {
        return this.rateOfReturn;
    }
}
