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

        lottoService.buyLottos();
    }

    private static void inputWinningNumbers() {
        while (true) {
            try {
                String input = InputView.inputWinningNumbers();
                List<Integer> winningNumbers = lottoService.inputLottoNumbers(input);
                InputValidator.valid(winningNumbers);
                lottoService.setWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {

            }
        }
    }

    private static void inputBonusNumber() {
        while (true) {
            try {
                String bonus = InputView.inputBonusNumber();
                InputValidator.validBonus(bonus);
                lottoService.setBonusNumber(Integer.parseInt(bonus));
                break; // 유효한 번호가 입력되면 루프 종료
            } catch (IllegalArgumentException e) {

            }
        }
    }

    private static void displayLottos() {
        OutputView.displayLottoNumbers(lottoService.getLottos(), lottoService.getLottoCount());
    }

    private static void checkResult() {
        OutputView.displayLottoStatistics();
        lottoService.checkResult();
    }
}
