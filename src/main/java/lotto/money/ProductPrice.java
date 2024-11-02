package lotto.money;


public class ProductPrice {
    private static final int EMPTY_MONEY = 0;

    private final int price;

    public ProductPrice(int price) {
        if(price <= EMPTY_MONEY)
            throw new IllegalArgumentException("판매 금액은 양수만 가능합니다.");
        this.price = price;
    }

    public int countPurchasableProduct(Money money) {
        return money.amount / price;
    }

    public boolean hasChange(Money money) {
        return money.amount % price != 0;
    }

}
