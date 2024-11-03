package lotto.view;

import lotto.dto.WinningNumberDTO;
import lotto.io.Input;
import lotto.io.Output;
import lotto.message.IOMessage;
import lotto.model.Lotto;
import lotto.validation.WinningBonusNumberValidation;

public final class WinningBonusNumberView {
    public static WinningNumberDTO winningBonusNumber() {
        Lotto winningLotto = winningNumberInput();
        int bonusNumber = bonusNumberInput(winningLotto);
        return new WinningNumberDTO(winningLotto, bonusNumber);
    }

    private static Lotto winningNumberInput() {
        while (true) {
            try {
                Output.printlnMessage(IOMessage.INPUT_WINNING_NUMBER.getMessage());
                String winningNumber = Input.inputMessage();
                return WinningBonusNumberValidation.getValidatedWinningNumbers(winningNumber);
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }

    private static int bonusNumberInput(Lotto winningLotto) {
        while (true) {
            try {
                Output.printlnMessage(IOMessage.INPUT_BONUS_NUMBER.getMessage());
                String bonusNumber = Input.inputMessage();
                return WinningBonusNumberValidation.getValidatedBonusNumber(winningLotto, bonusNumber);
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }
}