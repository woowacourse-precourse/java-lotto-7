package lotto.model;

public class PurchaseAmount {
    private int money;

    public PurchaseAmount() {
        this.money = 0; // 초기화
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액은 1000으로 나누어 떨어져야 합니다.");
        }
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
    }

    public int getLottoTicketCount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액은 1000으로 나누어 떨어져야 합니다.");
        }
        return money / 1000; // 티켓 수 계산
    }
}
