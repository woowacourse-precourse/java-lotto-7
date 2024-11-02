package lotto.view;

import lotto.io.Output;
import lotto.message.IOMessage;

public final class WinningBonusNumberView {
    public static void winningBonusNumber() {
        winningNumberInput();
    }

    private static void winningNumberInput() {
        while (true) {
            try {
                Output.printlnMessage(IOMessage.INPUT_WINNING_NUMBER.getMessage());
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }
}