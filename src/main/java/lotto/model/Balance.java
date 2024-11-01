package lotto.model;

public class Balance {
    private int money;
    private final int ticket;

    public Balance(int money) {
        validate(money);
        this.money = money;
        this.ticket = this.money / 1000;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0 이상이어야 합니다.");
        }
        else if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public int getTicket() {
        return this.ticket;
    }
}
