package domain;

public class User {
    private static final int buyingUnit = 1000;
    private static final int zero = 0;
    int buyingPrice;
    int buyingQuantity;

    public User(String buyingPrice) {
        this.buyingPrice = validate(buyingPrice);
        this.buyingQuantity = (this.buyingPrice)/buyingUnit;
    }

    private int validate(String buyingPrice) {
        int convertToIntegerPrice = Integer.parseInt(buyingPrice);
        if (convertToIntegerPrice % buyingUnit != zero) {
            throw new IllegalArgumentException();
        }
        return convertToIntegerPrice;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public int getBuyingQuantity() {
        return buyingQuantity;
    }

}
