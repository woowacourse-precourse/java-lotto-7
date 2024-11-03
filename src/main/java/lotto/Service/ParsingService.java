package lotto.Service;

public class ParsingService {
    private int money;

    public void setMoney(String money) {
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }
}
