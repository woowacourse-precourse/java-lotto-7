package lotto.service;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputService {

    public int getPurchaseCount(LottoService lottoService) {
        while (true) {
            try {
                String amount = InputView.readAmount();
                return lottoService.getPurchaseCount(amount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public List<Integer> getNumbersInput(LottoService lottoService) {
        while (true) {
            try {
                List<String> numbersInput = InputView.readNumbers();
                return lottoService.getNumbers(numbersInput);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public int getBonusNumberInput(LottoService lottoService, List<Integer> numbers) {
        while (true) {
            try {
                String bonusInput = InputView.readBonusNumber();
                return lottoService.getBonusNumber(bonusInput, numbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
