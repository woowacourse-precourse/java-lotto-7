package input;

import constant.InputNotice;
import validation.LottoPurchaseAmountValidator;
import validation.Validator;

public class LottoPurchaseAmountInputProcessor implements InputProcessor<Integer> {

    private final Validator<Integer> lottoPurchaseAmountValidator;

    public LottoPurchaseAmountInputProcessor(LottoPurchaseAmountValidator lottoPurchaseAmountValidator) {
        this.lottoPurchaseAmountValidator = lottoPurchaseAmountValidator;
    }

    public Integer putValue() {
        while (true) {
            String inputAmount = receiveInput(InputNotice.PURCHASE_AMOUNT);
            try {
                Integer coin = changeInteger(inputAmount);
                lottoPurchaseAmountValidator.validate(coin);
                return coin;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
