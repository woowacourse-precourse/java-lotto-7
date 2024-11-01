package lotto.domain;

import java.util.List;

public class MoneyDTO {
    private int money;

    public MoneyDTO(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < 0 || money == 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0이나 음수가 되면 안됩니다.");
        }
        if (money%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

    //1000원으로 나눠서 총 lotto가능 횟수 나타냄
    public int getTicketNumber (){
        return money/1000;
    }

}
