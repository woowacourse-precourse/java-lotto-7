package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Integer money = Input.inputMoney();
        Lotto.start(money);
        List <Integer> winNumbers = Input.inputWinNumbers();
        Integer bonusNumber = Input.inputBonusNumber(winNumbers);

        System.out.println(money + " " + winNumbers+" "+bonusNumber);
    }
}
