package lotto.domain.purchase;

public class UserMoney {
    private final int money;

    public UserMoney(int money) {
        this.money = money;
    }

    public UserMoney spend(int spendMoney) {
        validatePositive(spendMoney);
        return new UserMoney(money - spendMoney);
    }

    public UserMoney earn(int earnMoney) {
        validatePositive(earnMoney);
        return new UserMoney(money + earnMoney);
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] Number must be a positive number");
        }
    }

    public float calculateRatioTo(UserMoney other) {
        return ((float) other.money / (float) money);
    }

    public int getValue() {
        return money;
    }
}
