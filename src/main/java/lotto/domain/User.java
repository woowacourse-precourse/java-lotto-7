package lotto.domain;

public class User {

    private final int purchasePrice;
    private long revenue;

    public User(int lottoCount) {
        this.purchasePrice = lottoCount;
        this.revenue = 0;
    }

    public void addRevenue(long revenue) {
        this.revenue += revenue;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public long getRevenue() {
        return revenue;
    }
}
