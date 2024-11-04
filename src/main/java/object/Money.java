package object;

public class Money {
    private final int money;

    public Money(int money) {
        minimumPriceValidate(money);
        buyRegulationValidate(money);
        this.money = money;
    }

    private void minimumPriceValidate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최소 1000원 입니다.");
        }
    }

    private void buyRegulationValidate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구입할 수 있습니다.");
        }
    }
}
