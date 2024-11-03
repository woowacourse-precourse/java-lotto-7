package lotto.controller;

import lotto.common.view.output.OutputView;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Winning;
import java.util.List;
import java.util.Map;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        final Lottos lottos = lottoService.getLottos();
        OutputView.printLottoNumber(lottos);

        final List<Integer> winningNumber = lottoService.getWinningNumber();
        Winning winning = lottoService.getWinning(winningNumber);

        final Map<Rank, Long> detail = lottoService.getWinningDetails(lottos, winning);
        final double profitRate = lottoService.getProfitRate(lottos, winning);

        OutputView.printWinningHistory(detail, profitRate);
    }

}
