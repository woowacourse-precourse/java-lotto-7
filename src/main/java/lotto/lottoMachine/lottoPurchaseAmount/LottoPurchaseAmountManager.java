package lotto.lottoMachine.lottoPurchaseAmount;

import lotto.lottoMachine.utils.StaticFinalMessages;

public class LottoPurchaseAmountManager {
    private final LottoPurchaseAmountInputter lottoPurchaseAmountInputter;
    private final LottoPurchaseAmountValidator lottoPurchaseAmountValidator;

    public LottoPurchaseAmountManager() {
        lottoPurchaseAmountInputter = new LottoPurchaseAmountInputter();
        lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator();
    }

    public int getPurchaseAmount() {
        while (true) {
            String lottoPurchaseAmount = lottoPurchaseAmountInputter.getInput();
            if (lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount)) {
                return Integer.parseInt(lottoPurchaseAmount);
            } else {
                System.out.println(StaticFinalMessages.ERROR_TEXT_INFRONT_OF_DETAILS
                        + StaticFinalMessages.RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_PURCHASE_AMOUNT);
            }
        }
    }
}
