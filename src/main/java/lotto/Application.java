package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Integer money = Input.inputMoney();
        List <Integer> winNumbers = Input.inputWinNumbers();
        Integer bonusNumber = Input.inputBonusNumber();

        System.out.println(money + " " + winNumbers+" "+bonusNumber);
    }
}
