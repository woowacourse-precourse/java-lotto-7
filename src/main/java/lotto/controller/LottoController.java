package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyAmount;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.StringUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void run() {
        buyAndPrintLottos();
        calculateAndPrintResult();
    }

    private void buyAndPrintLottos() {
        List<Lotto> lottos = lottoService.buyLottos(inputBuyAmount());

        OutputView.printLottos(lottos);
    }

    private LottoBuyAmount inputBuyAmount() {
        try {
            int amount = StringUtils.parseToInt(InputView.getBuyAmount());

            return new LottoBuyAmount(amount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputBuyAmount();
        }
    }

    private void calculateAndPrintResult() {
        WinningLotto winningLotto = inputWinningLotto();
        BonusNumber bonusNumber = inputBonusNumber(winningLotto.getWinningNumbers());
        LottoResult result = lottoService.calculateResult(winningLotto, bonusNumber);

        printResult(result);
    }

    private WinningLotto inputWinningLotto() {
        try {
            List<Integer> winningNumbers = StringUtils.parseNumbers(InputView.getWinningNumbers());

            return new WinningLotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputWinningLotto();
        }
    }

    private BonusNumber inputBonusNumber(List<Integer> winningNumbers) {
        try {
            int bonusNumber = StringUtils.parseToInt(InputView.getBonusNumber());

            return new BonusNumber(bonusNumber, winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }

    private void printResult(LottoResult result) {
        OutputView.printResultMessage();
        OutputView.printMatchCounts(result);
        OutputView.printProfitRate(result);
    }
}
