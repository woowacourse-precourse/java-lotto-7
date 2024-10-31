package lotto;

public class UserLotto {
    private int price;
    private Lotto lotto;

    public UserLotto(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ErrorMessage.printError(ErrorMessage.ERROR_PRICE_UNDER_ZERO));
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.printError(ErrorMessage.ERROR_PRICE_NOT_IN_UNITS_OF_1000));
        }
    }
}
