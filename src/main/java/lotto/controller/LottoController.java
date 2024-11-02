package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.helper.ParseHelper;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;
import lotto.model.constant.LottoRank;
import lotto.service.LottoRateOfReturnService;
import lotto.service.LottoService;
import lotto.service.LottoStatisticsService;
import lotto.view.ErrorView;
import lotto.view.LottoStatisticsView;
import lotto.view.LottoView;

public class LottoController {

    private final ParseHelper parseHelper;
    private final LottoService lottoService;
    private final LottoStatisticsService lottoStatisticsService;
    private final LottoRateOfReturnService lottoRateOfReturnService;

    public LottoController() {
        this.parseHelper = new ParseHelper();
        this.lottoService = new LottoService();
        this.lottoStatisticsService = new LottoStatisticsService();
        this.lottoRateOfReturnService = new LottoRateOfReturnService();
    }

    public List<Lotto> buyLotto() {
        List<Lotto> lottos = null;

        while (lottos == null) {
            try {
                String input = LottoView.inputBuyAmount();
                int buyAmount = parseHelper.parseInt(input);
                lottos = lottoService.buy(buyAmount);
            } catch (IllegalArgumentException exception) {
                ErrorView.announceError(exception);
            }
        }
        LottoView.announceBoughtLotto(lottos);

        return lottos;
    }

    public void announceStatistics(List<Lotto> lottos, FirstRankLotto firstRankLotto) {
        Map<LottoRank, Integer> lottoStatistics = lottoStatisticsService.getStatistics(lottos, firstRankLotto);

        LottoStatisticsView.announceStatistics(lottoStatistics);
    }

    public void annouceLottoRateOfReturn(List<Lotto> lottos, FirstRankLotto firstRankLotto) {
        double percentRateOfReturn = lottoRateOfReturnService.getRateOfReturn(lottos, firstRankLotto) * 100;

        LottoStatisticsView.announcePercentOfReturn(percentRateOfReturn);
    }
}
