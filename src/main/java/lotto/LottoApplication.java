package lotto;

import static lotto.Inputor.getMoney;

public class LottoApplication {
    public static final int INCORRECT_MONEY = -1;
    public void start(){

        int money = INCORRECT_MONEY;

        while(money == INCORRECT_MONEY) {
            money = getMoney();
        }

    }
}
