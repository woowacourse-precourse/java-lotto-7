package lotto.controller;

import java.util.List;
import lotto.Service.LottoService;
import lotto.Vaildator.InputValidator;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
    private static final LottoService lottoService = new LottoService();

    public static void lottoStart() {
        buyLottos();
        displayLottos();
        inputWinningNumbers();
        inputBonusNumber();
        checkResult();
    }

    private static void buyLottos() {
        int amount = InputView.inputPay();
        lottoService.buyLottos(amount);
    }

    private static void inputWinningNumbers() {
        String input = InputView.inputWinningNumbers();
        List<Integer> winningNumbers = lottoService.inputLottoNumbers(input);
        InputValidator.valid(winningNumbers);
        lottoService.setWinningNumbers(winningNumbers);
    }

    private static void inputBonusNumber() {
        String bonus = InputView.inputBonusNumber();
        InputValidator.validBonus(bonus);
        lottoService.setBonusNumber(Integer.parseInt(bonus));
    }

    private static void displayLottos() {
        OutputView.displayLottoNumbers(lottoService.getLottos());
    }

    private static void checkResult() {
        OutputView.displayLottoStatistics();
        lottoService.checkResult();
    }
}
