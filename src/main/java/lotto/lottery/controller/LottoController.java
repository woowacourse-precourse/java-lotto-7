package lotto.lottery.controller;

import static lotto.global.util.LottoConst.LOTTO_PRICE;

import java.util.List;
import java.util.Map;
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

    public LottoController(LottoService lottoService,
                           WinningNumberService winningNumberService,
                           MatchService matchService) {
        this.lottoService = lottoService;
        this.winningNumberService = winningNumberService;
        this.matchService = matchService;
    }

    public void start() {

        try {
            String amountInput = InputView.printPurchaseLotto();
            List<Lotto> lottos = purchaseLottos(amountInput);

            WinningNumber winningNumber = getWinningNumber();
            Map<LottoResult, Integer> matchResults = matchService.calculateMatchResults(lottos, winningNumber);

            printWinningResult(matchResults);
            printReturnRate(matchResults, lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos(String amountInput) {
        List<Lotto> lottos = lottoService.purchaseLottos(amountInput);
        OutputView.printEmpty();
        OutputView.printLottos(lottos);
        return lottos;
    }

    private WinningNumber getWinningNumber() {
        OutputView.printEmpty();
        String winningNumbers = InputView.printWinningNumbers();

        OutputView.printEmpty();
        String bonusNumber = InputView.printBonusNumber();

        return winningNumberService.create(winningNumbers, bonusNumber);
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
