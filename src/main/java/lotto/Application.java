package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Input input = new Input();
            int money = input.moneyInput();

            LottoNum lottoNum = new LottoNum(money);
            List<Integer> numbers = input.numberInput();
            int bonus = input.bonusInput();
            lottoNum.printResult(numbers, bonus, money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
