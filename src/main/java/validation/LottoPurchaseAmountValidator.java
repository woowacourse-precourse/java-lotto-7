package validation;

import constant.ErrorMessage;
import constant.Price;

public class LottoPurchaseAmountValidator implements Validator<Integer> {

    @Override
    public void validate(Integer amount) {
        checkAmount(amount);
    }

    public void checkAmount(Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NEGATIVE_NUMBER.show());
        }
        if (amount % Price.LOTTOPRICE.getPrice() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDE_AMOUNT.show());
        }
    }

}
