package lotto;

import java.util.List;
import java.util.Map;
import lotto.common.Winning;
import lotto.controller.LottoController;
import lotto.controller.LottoResultController;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        LottoResultController lottoResultController = new LottoResultController();

        int payment = lottoController.pay();
        List<Lotto> lottos = lottoController.buyLottos(payment);

        List<Integer> winningNumbers = lottoController.postWinningNumbers();
        int bonus = lottoController.postBonus();

        Map<Winning, Integer> result = lottoResultController.getWinnings(lottos, winningNumbers, bonus);
        double yield = lottoResultController.getYield(result, payment);

        lottoResultController.printResult(result, yield);
    }
}
