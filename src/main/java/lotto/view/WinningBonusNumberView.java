package lotto.view;

import lotto.io.Input;
import lotto.io.Output;
import lotto.message.IOMessage;
import lotto.model.Lotto;
import lotto.validation.WinningBonusNumberValidation;

public final class WinningBonusNumberView {
    public static void winningBonusNumber() {
        Lotto winningLotto = winningNumberInput();
        int bonusNumber = bonusNumberInput(winningLotto);
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