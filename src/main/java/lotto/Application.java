package lotto;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final int cost = Input.getCost();
        List<Lotto> lottoPaper = (new Generate(cost)).getLottoPaper();
        Output.printLotto(lottoPaper);

        final List<Integer> winningNumbers = Input.getWinNumbers();
        System.out.println();

        final int bonus = Input.getBonusNumber(winningNumbers);
        System.out.println();


        Lottos lottos = new Lottos(lottoPaper);
        lottos.searchAll(winningNumbers, bonus);

        Output.printWinner(cost);
    }
}
