package lotto.view.input;

import lotto.domain.bonus.BonusNumber;
import lotto.domain.winning.WinningNumbers;
import lotto.exception.bonus.BonusErrorMessages;
import lotto.exception.lotto.LottoErrorMessages;
import lotto.exception.winningNumbers.WinningNumbersErrorMessages;
import lotto.service.lotto.LottoServiceImpl;

public class InputHandler {
   public static int getValidatedAmount() {
        while (true) {
            try {
                String input = InputView.getAmount();
                new LottoServiceImpl().validateAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(LottoErrorMessages.INVALID_AMOUNT_NON_NUMERIC.getMessage());
            }
        }
    }
    public WinningNumbers getValidatedWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = InputView.getWinningNumbers();
                return new WinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(WinningNumbersErrorMessages.INVALID_SIZE.getMessage());
            }
        }
    }

    public BonusNumber getValidatedBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = InputView.getBonusNumber();
                return new BonusNumber(bonusNumberInput, winningNumbers.getNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(BonusErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }
}