package lotto;

public enum Result {
    Three(5000),
    Four(50000),
    Five(1500000),
    Bonus(30000000),
    Six(2000000000);
    private final int price;
    Result(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}
