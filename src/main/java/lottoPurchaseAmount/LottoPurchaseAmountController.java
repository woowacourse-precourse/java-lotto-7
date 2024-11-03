package lottoPurchaseAmount;

public class LottoPurchaseAmountController {
    private final LottoPurchaseAmountInputter lottoPurchaseAmountInputter;
    private final LottoPurchaseAmountValidator lottoPurchaseAmountValidator;

    public LottoPurchaseAmountController() {
        lottoPurchaseAmountInputter = new LottoPurchaseAmountInputter();
        lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator();
    }

    public int getPurchaseAmount() {
        String lottoPurchaseAmount = lottoPurchaseAmountInputter.runAndBringInput();
        lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount);

        return Integer.parseInt(lottoPurchaseAmount);
    }
}
