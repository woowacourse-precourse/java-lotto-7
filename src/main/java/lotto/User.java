package lotto;

public class User {
    private static final int STANDARD_UNIT = 1000;

    private int money;

    public User(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money % STANDARD_UNIT != 0) {
            throw new IllegalArgumentException("돈은 1,000 단위로 나눠 떨어져야 합니다.");
        }
    }

    public int getPurchaseQuantity() {
        return money / STANDARD_UNIT;
    }
}
