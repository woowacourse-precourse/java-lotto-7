package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final double cost = Input.getCost();
        List<Lotto> lottoPaper = (new Generate(cost)).getLottoPaper();
        Output.printLottoPaper(lottoPaper);

        final List<Integer> winningNumbers = Input.getWinNumbers();
        final int bonus = Input.getBonusNumber(winningNumbers);

        Lottos lottos = new Lottos(lottoPaper);
        lottos.searchAll(winningNumbers, bonus);

        Output.printWinningList(cost);
    }
}
