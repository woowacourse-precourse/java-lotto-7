package lotto.view.input;

import lotto.domain.model.bonus.BonusNumber;
import lotto.domain.model.winning.WinningNumbers;
import lotto.exception.bonus.BonusErrorMessages;
import lotto.exception.lotto.LottoErrorMessages;
import lotto.exception.winning.WinningNumbersErrorMessages;
import lotto.service.LottoApplicationServiceImpl;

import java.util.function.Supplier;

public class InputHandler {

    public static int getValidatedAmount() {
        return handleInput(() -> {
            String input = InputView.getAmount();
            new LottoApplicationServiceImpl().validateAmount(input);
            return Integer.parseInt(input);
        }, LottoErrorMessages.INVALID_AMOUNT_NON_NUMERIC.getMessage());
    }

    public WinningNumbers getValidatedWinningNumbers() {
        return handleInput(() -> {
            String winningNumbersInput = InputView.getWinningNumbers();
            return new WinningNumbers(winningNumbersInput);
        }, WinningNumbersErrorMessages.INVALID_SIZE.getMessage());
    }

    public BonusNumber getValidatedBonusNumber(WinningNumbers winningNumbers) {
        return handleInput(() -> {
            String bonusNumberInput = InputView.getBonusNumber();
            return new BonusNumber(bonusNumberInput, winningNumbers.getNumbers());
        }, BonusErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
    }

    private static <T> T handleInput(Supplier<T> inputSupplier, String errorMessage) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }
    }
}