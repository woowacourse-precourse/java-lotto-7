package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int amount;
    private double rateOfReturn;
    private List<Lotto> lottos;
    private List<Rank> ranks;

    public User(int amount) {
        this.amount = amount;
        this.rateOfReturn = 0.0;
        this.lottos = new ArrayList<>();
        this.ranks = new ArrayList<>();
    }

    public void updateLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addRank(Rank rank) {
        this.ranks.add(rank);
    }

    public void updateRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public int getPurchaseCount() {
        return this.amount / 1_000;
    }

    public int getAmount() {
        return this.amount;
    }

    public double getRateOfReturn() {
        return this.rateOfReturn;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public List<Rank> getRanks() {
        return this.ranks;
    }
}
