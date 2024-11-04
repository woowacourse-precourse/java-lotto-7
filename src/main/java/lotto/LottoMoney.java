package lotto;

public class LottoMoney {

    private int money;

    public LottoMoney(int money) {
        validateMoney(money);
        this.money = money;
    }
    private void validateMoney(int money) {
        if (money != 0 && money % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위여야 합니다."); // 예외 발생
        }
    }

    public int getPurchaseCount() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
