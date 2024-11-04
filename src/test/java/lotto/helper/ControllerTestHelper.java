package lotto.helper;

import lotto.view.InputView;
import lotto.view.OutputView;

public class ControllerTestHelper {

    public static InputView createStubInputView(String buyAmount, String winningNumbers, String bonusNumber) {
        return new InputView() {
            @Override
            public String getBuy() {
                return buyAmount;
            }

            @Override
            public String getWinningNum() {
                return winningNumbers;
            }

            @Override
            public String getBonusNum() {
                return bonusNumber;
            }
        };
    }

    public static OutputView createStubOutputView() {
        return new OutputView() {
            @Override
            public void printMessage(String message) {
                System.out.println(message);            }
        };
    }
}
