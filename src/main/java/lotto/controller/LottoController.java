package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    private final LottoResult lottoResult = new LottoResult();
    private static int count;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public void run() {
        inputCount();
        inputWinningNumbers();
        inputBonusNumber();
        checkLotto();
        outputWinningResult();
    }

    private void inputCount() {
        while (true) {
            try {
                String inputCount = inputView.readPurchaseAmount();
                count = lottoService.extractLottoCount(inputCount);
                outputView.printLottoCount(count);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.readWinningNumbers();
                winningNumbers = lottoService.extractWinningNumbers(inputWinningNumbers);
                Validator.checkDuplicateLottoNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                String inputBonusNumbers = inputView.readBonusNumber();
                bonusNumber = lottoService.extractBonusNumber(inputBonusNumbers);
                Validator.checkDuplicateBonusNumbers(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkLotto() {
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            outputView.printLottoNumbers(lotto.getNumbers());
            LottoCount lottoCount = lotto.matchLottoNumbers(winningNumbers, bonusNumber);
            lottoResult.updateWinningResult(lottoCount);
        }
        lottoResult.calculatePrize();
    }

    private void outputWinningResult() {
        outputView.printWinningStatistics(lottoResult, count);
    }
}
