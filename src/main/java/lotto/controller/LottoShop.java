package lotto.controller;

import lotto.Lotto;
import lotto.model.*;
import lotto.view.LottoView;
import java.util.List;

public class LottoShop {
    private final LottoMachine lottoMachine;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void runLotto() {
        LottoAmount amount = processPurchaseAmount();
        List<Lotto> lottos = processBuyLotto(amount.getAmount());
        WinningLotto winningLotto = processWinningLotto();
        processWinningStatistics(amount, lottos, winningLotto);
    }

    private LottoAmount processPurchaseAmount() {
        while (true) {
            try {

                return new LottoAmount(LottoView.requestPurchasePrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> processBuyLotto(int amount) {
        List<Lotto> lottos = lottoMachine.buyLottos(amount);
        LottoView.printLottos(lottos);

        return lottos;
    }

    private WinningLotto processWinningLotto() {
        List<Integer> winningNumbers = drawWinningNumbers();
        int bonusNumber = drawBonusNumber(winningNumbers);

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> drawWinningNumbers() {
        while (true) {
            try {

                return LottoView.requestWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int drawBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {

                return LottoView.requestBonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void processWinningStatistics(LottoAmount lottoAmount, List<Lotto> lottos, WinningLotto winningLotto) {
        List<LottoResult> lottoResults = StatisticsCalculator.checkLotto(lottos, winningLotto);

        RankStorage rankStorage = new RankStorage();
        StatisticsCalculator.calculateRankCounts(lottoResults, rankStorage);

        LottoView.printWinningStatistics(lottoAmount, rankStorage);
    }
}
