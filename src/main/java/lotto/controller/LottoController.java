package lotto.controller;

import lotto.dto.LottoResultDTO;
import lotto.dto.LottosDTO;
import java.util.Arrays;
import java.util.List;
import lotto.model.AttemptCount;
import lotto.model.BonusNumber;
import lotto.model.LottoManager;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.util.GenerateNumbers;
import lotto.util.RetryUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GenerateNumbers generateNumbers;

    public LottoController(InputView inputView, OutputView outputView, GenerateNumbers generateNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generateNumbers = generateNumbers;
    }

    public void start() {
        int purchaseAmount = readPurchaseAmount();
        AttemptCount attemptCount = AttemptCount.from(purchaseAmount);
        Lottos lottos = generateLottos(attemptCount);

        displayLottos(lottos);

        WinningNumbers winningNumbers = createWinningNumbersFromInput();
        BonusNumber bonusNumber = createBonusNumberFromInput(winningNumbers);

        displayResults(purchaseAmount, lottos, winningNumbers, bonusNumber);
    }

    private int readPurchaseAmount() {
        return Integer.parseInt(RetryUtil.retryReadPurchaseAmount(inputView::readPurchaseAmount));
    }

    private Lottos generateLottos(AttemptCount attemptCount) {
        return Lottos.of(attemptCount.getCount(), generateNumbers);
    }

    private void displayLottos(Lottos lottos) {
        LottosDTO lottosDTO = LottosDTO.from(lottos.getLottos());
        outputView.printLottos(lottosDTO);
    }

    private WinningNumbers createWinningNumbersFromInput() {
        String input = RetryUtil.retryReadWinningNumber(inputView::readWinningNumber);
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        return new WinningNumbers(winningNumbers);
    }

    private BonusNumber createBonusNumberFromInput(WinningNumbers winningNumbers) {
        int bonusNumber = Integer.parseInt(
                RetryUtil.retryReadBonusNumber(inputView::readBonusNumber, winningNumbers.winningNumbers()));

        return BonusNumber.of(bonusNumber, winningNumbers.winningNumbers());
    }

    private void displayResults(int purchaseAmount, Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        LottoManager lottoManager = LottoManager.of(lottos, winningNumbers, bonusNumber);
        LottoResultDTO lottoResultDTO = LottoResultDTO.of(lottoManager.getResults(),
                lottoManager.calculateRateOfReturn(purchaseAmount));
        outputView.printResults(lottoResultDTO);
    }
}
