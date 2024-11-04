package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;
    private final InputValidator inputValidator;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputValidator = new InputValidator();
    }

    public void run() {
        try {
            List<Lotto> lottos = purchaseLottos();
            WinningLotto winningLotto = createWinningLotto();
            printWinningStatistics(lottos, winningLotto);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos() {
        int amount = readPurchaseAmount();
        int count = lottoService.calculateLottoCount(amount);
        List<Lotto> lottos = lottoService.generateLottos(count);
        printPurchasedLottos(count, lottos);
        return lottos;
    }

    private int readPurchaseAmount() {
        String input = InputView.readLine();
        inputValidator.validateAmount(input);
        return Integer.parseInt(input);
    }

    private void printPurchasedLottos(int count, List<Lotto> lottos) {
        OutputView.printPurchaseCount(count);
        OutputView.printLottos(lottos);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);
        return lottoService.createWinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> readWinningNumbers() {
        OutputView.printWinningNumbersInputMessage();
        String input = InputView.readLine();
        inputValidator.validateWinningNumbers(input);
        return lottoService.convertToNumbers(input);
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        OutputView.printBonusNumberInputMessage();
        String input = InputView.readLine();
        inputValidator.validateBonusNumber(input, winningNumbers);
        return Integer.parseInt(input);
    }

    private void printWinningStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> statistics = lottoService.calculateWinningStatistics(lottos, winningLotto);
        OutputView.printWinningStatistics(statistics);

        double returnRate = lottoService.calculateReturnRate(statistics, lottos.size() * 1000);
        OutputView.printReturnRate(returnRate);
    }
}