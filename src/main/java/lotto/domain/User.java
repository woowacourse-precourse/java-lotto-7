package lotto.domain;

import lotto.util.UserIdGenerator;

public class User {

    private final int id;
    private final int purchasePrice;
    private long revenue;

    public User(int purchasePrice) {
        this.id = UserIdGenerator.generateId();
        this.purchasePrice = purchasePrice;
        this.revenue = 0;
    }

    public void addRevenue(long revenue) {
        this.revenue += revenue;
    }

    public int getId() {
        return id;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public long getRevenue() {
        return revenue;
    }
}
