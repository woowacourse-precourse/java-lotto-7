package lotto.domain.purchase;

public class UserMoney {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public UserMoney(int money) {
        this.money = money;
    }

    public UserMoney(LottoMoney lottoMoney) {
        this.money = lottoMoney.getValue();
    }

    public int calculateAvailableLottoCount() {
        return money / LOTTO_PRICE;
    }

    public UserMoney getMaxSpendAvailable() {
        return new UserMoney(calculateAvailableLottoCount() * LOTTO_PRICE);
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
            throw new IllegalArgumentException("Number must be a positive number");
        }
    }

    public float calculateRatioTo(UserMoney other) {
        return ((float) other.money / (float) money);
    }

    public int getValue() {
        return money;
    }
}
