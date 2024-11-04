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
        LottoMoney lottoMoney = createLottoMoney();
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator(), lottoMoney);
        List<Lotto> lottos = lottoMachine.issueLottos();

        outputView.displayPurchasedLotto(PurchasedLottoResponse.of(lottoMoney.getDrawCount(), lottos));
        winningStatisticsProcess(lottos, lottoMoney);
    }

    private Lotto createWinningLotto() {
        try {
            return new LottoGenerator(inputView::displayReadWinningNumbers).issueLotto();
        } catch (IllegalArgumentException e) {
            outputView.displayException(e.getMessage());
        }
        return createWinningLotto();
    }

    private LottoMoney createLottoMoney() {
        try {
            return LottoMoney.from(inputView.displayReadPurchaseAmount());
        } catch (IllegalArgumentException e) {
            outputView.displayException(e.getMessage());
        }
        return createLottoMoney();
    }

    private WinningNumber createWinningNumber(Lotto winningLotto) {
        try {
            return new WinningNumber(winningLotto, LottoNumber.from(inputView.displayReadBonusNumber()));
        } catch (IllegalArgumentException e) {
            outputView.displayException(e.getMessage());
        }
        return createWinningNumber(winningLotto);
    }

    private void winningStatisticsProcess(List<Lotto> lottos, LottoMoney lottoMoney) {
        WinningNumber winningNumber = createWinningNumber(createWinningLotto());
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