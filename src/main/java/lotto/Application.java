package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();

        Integer pay = input.getMoney();
        List<Integer> inputPrizeNumber = input.getPrizeNumbers();
        Integer bonus = input.getBonus();
        Lotto lotto = new Lotto(
                inputPrizeNumber,
                pay,
                bonus
        );

        lotto.play();
    }
}
