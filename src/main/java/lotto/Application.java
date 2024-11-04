package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.service.LottoService;
import lotto.util.InputHandler;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        int money = InputHandler.getPurchaseAmount();
        int lottoCount = money / 1000;

        List<Lotto> lottos = lottoService.createLottos(lottoCount);

        LottoGame game = InputHandler.getWinningNumbers();
        Map<Integer, Integer> ranks = lottoService.calculateRanks(lottos, game);

        long totalMoney = lottoService.getTotalMoney(ranks);
        double rate = lottoService.calculateRate(money, totalMoney);
    }
}
