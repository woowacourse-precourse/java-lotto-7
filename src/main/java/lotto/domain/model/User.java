package lotto.domain.model;

import java.util.Collections;
import java.util.List;

public class User {

    private final List<Lotto> lottos;
    private int totalAmountPurchased;
    private double profitRate;

    private User(int amount, List<Lotto> lottos) {
        this.totalAmountPurchased = amount;
        this.lottos = lottos;
    }

    public static User create(int amount, List<Lotto> lottos) {
        return new User(amount, lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int getTotalAmountPurchased() {
        return totalAmountPurchased;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void addTotalAmountPurchased(int amountPurchased) {
        this.totalAmountPurchased += amountPurchased;
    }

    public void changeProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }
}
