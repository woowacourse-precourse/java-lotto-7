package lotto.controller;

import java.util.Collections;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Revenue;
import lotto.model.Winning;
import lotto.policy.PrizeMoneyPolicy;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        OutputView.purchasedBudget();

        Revenue revenue = new Revenue(InputView.budget());
        int ticketCount = lottoService.ticketCount(revenue.getBudget());
        OutputView.PurchasedLottoTicketsMessage(ticketCount);

        List<Lotto> lottos = lottoService.buyLottos(revenue.getBudget());
        printAllLottos(lottos);

        Winning winning = winningLotto();

//        OutputView.winningStatistics();

        List<PrizeMoneyPolicy> ranks = findRanks(lottos, winning);
        result(ranks);

        double rateOfReturn = revenue.rateOfReturn(ranks);
        OutputView.totalRateOfReturn(rateOfReturn);

    }

    private void printAllLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(OutputView::lottoNumbers);
    }

    private Winning winningLotto() {
        OutputView.winningNumbers();
        Lotto winningLotto = new Lotto(InputView.winningNumbers());
        OutputView.bonusNumbers();
        Bonus bonus = new Bonus(InputView.bonusNumber());

        return new Winning(winningLotto, bonus);
    }

    private List<PrizeMoneyPolicy> findRanks(List<Lotto> lottos, Winning winning) {
       return lottos.stream()
                .map(winning::getRank)
                .toList();
    }

    public void result(List<PrizeMoneyPolicy> resultRanks){
        List<PrizeMoneyPolicy> ranks =
                List.of(PrizeMoneyPolicy.FIFTH,
                        PrizeMoneyPolicy.FOURTH,
                        PrizeMoneyPolicy.THIRD,
                        PrizeMoneyPolicy.SECOND,
                        PrizeMoneyPolicy.FIRST
                );

        ranks.forEach(rank -> OutputView.result(rank, Collections.frequency(resultRanks, rank)));
    }
}
