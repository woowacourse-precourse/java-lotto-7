package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        int money = input.moneyInput();

        try {
            LottoNum lottoNum = new LottoNum(money);
            List<Integer> numbers = input.numberInput();
            int bonus = input.bonusInput();
            lottoNum.printResult(numbers, bonus, money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
