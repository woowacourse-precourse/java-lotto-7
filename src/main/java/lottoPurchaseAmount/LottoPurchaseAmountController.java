package lottoPurchaseAmount;

import convert.SingleStringToNumConverter;
import lottoWinningNumber.LottoWinningNumberInputter;
import lottoWinningNumber.LottoWinningNumberValidator;

public class LottoPurchaseAmountController {
    private final LottoPurchaseAmountInputter lottoPurchaseAmountInputter;
    private final LottoPurchaseAmountValidator lottoPurchaseAmountValidator;
    private final SingleStringToNumConverter singleStringToNumConverter;

    public LottoPurchaseAmountController() {
        lottoPurchaseAmountInputter = new LottoPurchaseAmountInputter();
        lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator();
        singleStringToNumConverter = new SingleStringToNumConverter();
    }

    public int runAndBringPurchaseAmount() {
        String lottoPurchaseAmount = lottoPurchaseAmountInputter.runAndBringInput();
        lottoPurchaseAmountValidator.validateAllThing(lottoPurchaseAmount);

        return singleStringToNumConverter.convert(lottoPurchaseAmount);
    }
}
