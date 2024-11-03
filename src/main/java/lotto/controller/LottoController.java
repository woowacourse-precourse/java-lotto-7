package lotto.controller;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.LottoMoney;
import lotto.domain.machine.generator.LottoGenerator;
import lotto.domain.machine.generator.impl.RandomNumberGenerator;
import lotto.domain.winning.LottoRank;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningStatistics;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.dto.LottoStatisticsResponse;
import lotto.ui.dto.PurchasedLottoResponse;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            LottoMoney lottoMoney = LottoMoney.from(inputView.displayReadPurchaseAmount());
            LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator(), lottoMoney);
            List<Lotto> lottos = lottoMachine.issueLottos();

            outputView.displayPurchasedLotto(PurchasedLottoResponse.of(lottoMoney.getDrawCount(), lottos));
            displayResults(lottos, lottoMoney, createWinningNumber());
        } catch (IllegalArgumentException exception) {
            outputView.displayException(exception.getMessage());
        }
    }

    private WinningNumber createWinningNumber() {
        LottoGenerator winningLottoGenerator = new LottoGenerator(inputView::displayReadWinningNumbers);

        return new WinningNumber(
                winningLottoGenerator.issueLotto(),
                LottoNumber.from(inputView.displayReadBonusNumber())
        );
    }

    private void displayResults(List<Lotto> lottos, LottoMoney lottoMoney, WinningNumber winningNumber) {
        WinningStatistics statistics = calculateStatistics(lottos, winningNumber);

        outputView.displayWinningStatistics(LottoStatisticsResponse.of(
                statistics.getWinningCountByPrizes(),
                lottoMoney.getProfitRate(statistics.getTotalPrize())
        ));
    }

    private WinningStatistics calculateStatistics(List<Lotto> lottos, WinningNumber winningNumber) {
        WinningStatistics statistics = new WinningStatistics();
        for (Lotto lotto : lottos) {
            LottoRank rank = winningNumber.match(lotto);
            statistics.addWinCountByRank(rank);
        }
        return statistics;
    }

}