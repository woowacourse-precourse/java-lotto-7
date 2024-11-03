package lotto.lottery.controller;

import static lotto.global.util.LottoConst.LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import lotto.global.io.InputHandler;
import lotto.global.io.InputView;
import lotto.global.io.OutputView;
import lotto.global.util.MessageFormatter;
import lotto.lottery.domain.Lotto;
import lotto.lottery.service.LottoService;
import lotto.winningNumber.domain.LottoResult;
import lotto.winningNumber.domain.WinningNumber;
import lotto.winningNumber.service.MatchService;
import lotto.winningNumber.service.WinningNumberService;

public class LottoController {

    private final LottoService lottoService;
    private final WinningNumberService winningNumberService;
    private final MatchService matchService;
    private final InputHandler inputHandler;

    public LottoController(LottoService lottoService,
                           WinningNumberService winningNumberService,
                           MatchService matchService, InputHandler inputHandler) {
        this.lottoService = lottoService;
        this.winningNumberService = winningNumberService;
        this.matchService = matchService;
        this.inputHandler = inputHandler;
    }

    public void start() {
        List<Lotto> lottos = purchaseLottos();
        printLottos(lottos);

        OutputView.printEmpty();
        WinningNumber winningNumber = getWinningNumber();
        Map<LottoResult, Integer> matchResults = matchService.calculateMatchResults(lottos, winningNumber);
        InputView.closeConsole();

        printWinningResult(matchResults);
        printReturnRate(matchResults, lottos);
    }

    private List<Lotto> purchaseLottos() {
        return inputHandler.execute(() -> {
            String amountInput = InputView.printPurchaseLotto();
            return lottoService.purchaseLottos(amountInput);
        });
    }

    private void printLottos(List<Lotto> lottos) {
        OutputView.printEmpty();
        OutputView.printLottos(lottos);
    }

    private WinningNumber getWinningNumber() {
        return inputHandler.execute(() -> {
            String winningNumbers = InputView.printWinningNumbers();

            OutputView.printEmpty();
            String bonusNumber = InputView.printBonusNumber();

            return winningNumberService.create(winningNumbers, bonusNumber);
        });
    }

    private void printWinningResult(Map<LottoResult, Integer> matchResults) {
        OutputView.printEmpty();
        OutputView.printWinningHeader();
        String winningStatics = MessageFormatter.getLotteryResults(matchResults);
        OutputView.printWinningStatistics(winningStatics);
    }

    private void printReturnRate(Map<LottoResult, Integer> matchResults, List<Lotto> lottos) {
        String returnRate = MessageFormatter.getReturnRate(matchResults, lottos.size() * LOTTO_PRICE);
        OutputView.printReturnRate(returnRate);
    }

}
