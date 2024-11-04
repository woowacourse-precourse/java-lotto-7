package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.LotteryValidator;

public class InputView {
    private final LotteryValidator lotteryValidator;

    public InputView() {
        this.lotteryValidator = new LotteryValidator();
    }

    public int readPurchaseAmount() {
        String inputPurchaseAmount = Console.readLine();
        while (!lotteryValidator.validateInputPurchaseAmount(inputPurchaseAmount)) {
            inputPurchaseAmount = Console.readLine();
        }
        return Integer.parseInt(inputPurchaseAmount);
    }
}
