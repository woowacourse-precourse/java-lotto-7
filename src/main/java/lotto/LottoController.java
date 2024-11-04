package lotto;

import java.util.List;
import java.util.function.Predicate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public LottoController() {
    }

    public void run() {
        outputView.printInputCashMessage();
        String input = inputView.inputCash();
        Integer lottoAmount = lottoService.convertInputToCash(input);

        List<Lotto> lottos = lottoService.getLotto(lottoAmount);
        outputView.printLottoAmountMessage(lottoAmount);
        outputView.printLottos(lottos);

        outputView.printInputWinningNumberMessage();
        String winningNumbersInput = inputView.inputWinningNumber();
        Lotto winningLotto = lottoService.parseWinningNumber(winningNumbersInput);

        outputView.printInputBonusNumberMessage();
        String inputBonusNumber = inputView.inputBonusNumber();
        Integer bonusNumber = lottoService.parseBonusNumber(inputBonusNumber);

        Integer price = 0;

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> winningNumbers = winningLotto.getNumbers();

            List<Integer> matchNumbers = lottoNumbers.stream().filter(o -> winningNumbers.stream()
                    .anyMatch(Predicate.isEqual(o))).toList();

            if (matchNumbers.size() == 6) {
                price += 2000000000;
            }
            if (matchNumbers.size() == 5 && lottoService.haveBonusNumber(lottoNumbers, bonusNumber)) {
                price += 30000000;
            }
            if (matchNumbers.size() == 5 && !lottoService.haveBonusNumber(lottoNumbers, bonusNumber)) {
                price += 1500000;
            }
            if (matchNumbers.size() == 4) {
                price += 50000;
            }
            if (matchNumbers.size() == 3) {
                price += 5000;
            }
        }
    }
}
