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
    private final ExceptionHandler exceptionHandler;

    public LottoController(InputView inputView, OutputView outputView, ExceptionHandler exceptionHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        LottoMoney lottoMoney = exceptionHandler.retry(this::createLottoMoney);
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator(), lottoMoney);
        List<Lotto> lottos = lottoMachine.issueLottos();
        outputView.displayPurchasedLotto(PurchasedLottoResponse.of(lottos));

        winningStatisticsProcess(lottos, lottoMoney);
    }

    private LottoMoney createLottoMoney() {
        return LottoMoney.from(inputView.displayReadPurchaseAmount());
    }

    private Lotto createWinningLotto() {
        return new LottoGenerator(inputView::displayReadWinningNumbers).issueLotto();
    }

    private WinningNumber createWinningNumber(Lotto winningLotto) {
        return new WinningNumber(winningLotto, LottoNumber.from(inputView.displayReadBonusNumber()));
    }

    private void winningStatisticsProcess(List<Lotto> lottos, LottoMoney lottoMoney) {
        Lotto winningLotto = exceptionHandler.retry(this::createWinningLotto);
        WinningNumber winningNumber = exceptionHandler.retry(() -> createWinningNumber(winningLotto));
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