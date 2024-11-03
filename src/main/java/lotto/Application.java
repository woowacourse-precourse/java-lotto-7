package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final double cost = Input.getCost();
        List<Lotto> lottoPaper = (new Generate(cost)).getLottoPaper();
        Output.printLottoPaper(lottoPaper);

        final List<Integer> winNumbers = Input.getWinNumbers();
        final int bonus = Input.getBonusNumber(winNumbers);

        Lottos lottos = new Lottos(lottoPaper);
        lottos.searchAll(winNumbers, bonus);

        Output.printWinningList(cost);
    }
}
