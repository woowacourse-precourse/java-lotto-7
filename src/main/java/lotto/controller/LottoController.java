package lotto.controller;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoStatisticsDto;
import lotto.service.LottoCheckService;
import lotto.service.LottoCreateService;
import lotto.service.LottoStatisticsService;
import lotto.view.View;

public class LottoController {

    private final View view;
    private final LottoCreateService lottoCreateService;
    private final LottoCheckService lottoCheckService;
    private final LottoStatisticsService lottoStatisticsService;

    public LottoController(View view) {
        this.view = view;
        lottoCreateService = new LottoCreateService();
        lottoCheckService = new LottoCheckService();
        lottoStatisticsService = new LottoStatisticsService();
    }

    public void run() {
        String money = view.getMoney();
        Lottos lottos = lottoCreateService.createLottosWithMoney(money);
        view.printLottos(lottos);

        String winningNumbers = view.getWinningNumbers();
        String bonusNumber = view.getBonusNumber();
        WinningLotto winningLotto = lottoCreateService.createWinningLotto(winningNumbers, bonusNumber);

        List<LottoRank> lottoRanks = lottoCheckService.checkRanks(winningLotto, lottos);

        LottoStatisticsDto result = lottoStatisticsService.getLottoStatistics(lottoRanks);
        view.printResult(result);

    }
}
