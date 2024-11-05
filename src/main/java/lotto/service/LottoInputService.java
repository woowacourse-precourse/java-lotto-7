package lotto.service;

import lotto.exception.LottoException;
import lotto.model.Lotto;
import lotto.model.LottoBonusNumber;
import lotto.validation.LottoPurchaseValidation;
import lotto.validation.LottoValidation;
import lotto.view.InputView;

import java.util.List;

public class LottoInputService {
    private final InputView inputView;

    public LottoInputService(InputView inputView) {
        this.inputView = inputView;
    }

    public int purchaseAmount() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                return LottoPurchaseValidation.validatePurchaseAmount(input);
            } catch (LottoException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public Lotto winningLotto() {
        String winningNumbersInput = inputView.readWinningNumber();
        List<Integer> winningNumbers = LottoValidation.validateWinningNumbers(winningNumbersInput);
        return new Lotto(winningNumbers);
    }

    public LottoBonusNumber bonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = inputView.readBonusNumber();
                int bonusNumber = LottoValidation.validateBonusNumber(bonusNumberInput);
                return new LottoBonusNumber(bonusNumber, winningNumbers);
            } catch (LottoException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
