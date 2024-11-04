package lotto.model;

public class Balance {
    private final int money;
    private final int ticket;
    private static final int LOTTO_PRICE = 1000;

    public Balance(int money) {
        validate(money);
        this.money = money;
        this.ticket = this.money / LOTTO_PRICE;
    }

    private void validate(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 이상이어야 합니다.");
        } else if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getMoney() {
        return this.money;
    }

    public int getTicket() {
        return this.ticket;
    }
}
