package constant;

public enum Price {
    LOTTOPRICE(1000);

    private final int price;

    Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
