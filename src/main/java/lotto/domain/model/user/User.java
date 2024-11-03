package lotto.domain.model.user;

import java.util.List;

public class User {

    private final UserPurchasedLotto lottos;
    private int totalAmountPurchased;
    private double profitRate = 0.0;

    private User(int amount, UserPurchasedLotto lottos) {
        this.totalAmountPurchased = amount;
        this.lottos = lottos;
    }

    public static User create(int amount, UserPurchasedLotto lottos) {
        return new User(amount, lottos);
    }

    public List<Lotto> getLottos() {
        return lottos.getUserPurchasedLotto();
    }

    public int getTotalAmountPurchased() {
        return totalAmountPurchased;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void addAmount(int amountPurchased) {
        this.totalAmountPurchased += amountPurchased;
    }

    public void changeProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }
}
