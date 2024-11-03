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
        int purchaseAmount = Integer.parseInt(RetryUtil.retryReadPurchaseAmount(inputView::readPurchaseAmount));
        AttemptCount attemptCount = new AttemptCount(purchaseAmount);
        Lottos lottos = new Lottos(attemptCount.getCount(), generateNumbers);

        LottosDTO lottosDTO = LottosDTO.from(lottos.getLottos());
        outputView.printLottos(lottosDTO);

        WinningNumbers winningNumbers = createWinningNumbersFromInput();
        BonusNumber bonusNumber = createBonusNumberFromInput(winningNumbers);

        LottoManager lottoManager = new LottoManager(lottos, winningNumbers, bonusNumber);
        LottoResultDTO lottoResultDTO = LottoResultDTO.of(lottoManager.getResults(),
                lottoManager.calculateRateOfReturn(purchaseAmount));
        outputView.printResults(lottoResultDTO);
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

        return new BonusNumber(bonusNumber, winningNumbers.winningNumbers());
    }
}
