package lotto;

public class Purchase {
    private static final int PRICE_OF_LOTTO = 1000;

    private final int money;

    public Purchase(String money) throws IllegalArgumentException {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        try {
            int moneyAmount = Integer.parseInt(money);
            if (moneyAmount % PRICE_OF_LOTTO != 0 || moneyAmount == 0) {
                throw new IllegalArgumentException("[ERROR] 0이 아닌 1000으로 나누어지는 수를 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 입력이 존재합니다.");
        }
    }

    public int money() {
        return money;
    }

    public int numberOfPurchases() {
        return money / PRICE_OF_LOTTO;
    }
}
