package lotto.controller;

import java.util.Arrays;
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
import lotto.ui.dto.WinningCountByPrize;

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

            WinningNumber winningNumber = createWinningNumber();

            displayResults(lottos, lottoMoney, winningNumber);
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
        List<WinningCountByPrize> winningCountByPrizes = createWinningCountByPrizes(statistics);

        LottoStatisticsResponse response = LottoStatisticsResponse.of(
                winningCountByPrizes,
                lottoMoney.getProfitRate(statistics.getTotalPrize())
        );

        outputView.displayWinningStatistics(response);
    }

    private WinningStatistics calculateStatistics(List<Lotto> lottos, WinningNumber winningNumber) {
        WinningStatistics statistics = new WinningStatistics();
        for (Lotto lotto : lottos) {
            LottoRank rank = winningNumber.match(lotto);
            statistics.addWinCountByRank(rank);
        }
        return statistics;
    }

    private List<WinningCountByPrize> createWinningCountByPrizes(WinningStatistics statistics) {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isWinning)
                .sorted((r1, r2) -> Integer.compare(r2.getRank(), r1.getRank()))
                .map(rank -> WinningCountByPrize.of(rank, statistics.getWinningCountByRank(rank)))
                .toList();
    }

}