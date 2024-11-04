package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.validator.LottoPurchaseAmountValidator;

public class LottoPurchaseAmountInput {

    private final LottoPurchaseAmountValidator lottoPurchaseAmountValidator;

    public LottoPurchaseAmountInput(LottoPurchaseAmountValidator lottoPurchaseAmountValidator) {
        this.lottoPurchaseAmountValidator = lottoPurchaseAmountValidator;
    }

    public Integer run() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        lottoPurchaseAmountValidator.validate(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }
}
