package lotto.view;

import lotto.io.Input;
import lotto.io.Output;
import lotto.message.IOMessage;
import lotto.model.Lotto;
import lotto.validation.WinningBonusNumberValidation;

public final class WinningBonusNumberView {
    public static void winningBonusNumber() {
        Lotto winninglotto = winningNumberInput();
        int bonusNumber = bonusNumberInput();
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

    private static int bonusNumberInput() {
        while (true) {
            try {
                Output.printlnMessage(IOMessage.INPUT_BONUS_NUMBER.getMessage());
                return 0;
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }
}