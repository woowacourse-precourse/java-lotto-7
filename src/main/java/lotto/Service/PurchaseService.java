package lotto.Service;

public class PurchaseService {
    public PurchaseService() { }

    public int buy(int money) {
        boolean validated = false;
        if(validate(money))
            return money / 1000;
        return -1;
    }

    private boolean validate(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("[ERROR] 구매 가격은 음수가 될 수 없습니다.");
        }
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매는 1,000원 단위로 가능합니다.");
        }
        return true;
    }
}
