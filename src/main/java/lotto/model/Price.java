package lotto.model;

public class Price {
    private final int price;

    public Price(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 가격을 입력하시오.");
        }
        
        if (price <= 0) {
            throw new IllegalArgumentException("[ERROR] 0초과의 값을 입력하시오.");
        }
    }

    public int getPrice() {
        return price;
    }
}
