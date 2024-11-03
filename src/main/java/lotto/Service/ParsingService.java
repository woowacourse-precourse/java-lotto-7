package lotto.Service;

public class ParsingService {
    private final int money;

    public ParsingService(String money) {
        this.money=Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }
}
