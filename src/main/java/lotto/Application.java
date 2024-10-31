package lotto;

import java.util.List;
import java.util.Map;
import lotto.common.Winning;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();

        int payment = lottoController.getPayment();
        List<Lotto> lottos = lottoController.initLotto(payment);

        List<Integer> winningNumbers = lottoController.getWinningNumbers();
        int bonus = lottoController.getBonus();

        Map<Winning, Integer> winnings = lottoController.getWinnings(lottos, winningNumbers, bonus);
        double yield = lottoController.getYield(winnings, payment);

        lottoController.printResult(winnings, yield);
    }
}
