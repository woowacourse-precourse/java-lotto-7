package lotto.view;

import lotto.io.Input;
import lotto.io.Output;
import lotto.message.IOMessage;
import lotto.model.Lotto;
import lotto.validation.WinningBonusNumberValidation;

public final class WinningBonusNumberView {
    public static void winningBonusNumber() {
        winningNumberInput();
    }

    private static void winningNumberInput() {
        while (true) {
            try {
                Output.printlnMessage(IOMessage.INPUT_WINNING_NUMBER.getMessage());
                String winningNumber = Input.inputMessage();
                Lotto winninglotto = WinningBonusNumberValidation.winningNumberValidation(winningNumber);
                System.out.println(winninglotto);
                return;
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }
}