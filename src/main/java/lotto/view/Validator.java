package lotto.view;

import lotto.exception.ExceptionMessage;

public class Validator {
    private final Policy policy;

    private Validator(Policy policy) {
        this.policy = policy;
    }

    public static Validator newInstance(Policy policy){
        return new Validator(policy);
    }

    public void validateAmountInput(String input){
        this.validateNumber(input);
        int purchasedAmount = Integer.parseInt(input);
        this.validatePositive(purchasedAmount);
        this.validatePurchasedAmount(purchasedAmount);
    }

    private void validatePurchasedAmount(int amount){
        if(!((amount % policy.getAmountPolicy()) == 0)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() +
                    ExceptionMessage.AMOUNT.getMessage() + policy.getAmountPolicy()
                    + ExceptionMessage.AMOUNT_UNIT.getMessage());
        }
    }

    private void validateNumber(String input){
        String integerRegex = policy.getIntegerRegex();
        if(!input.matches(integerRegex)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() +
                    ExceptionMessage.INPUT_NUMBER_EXCEPTION.getMessage());
        }
    }

    private void validatePositive(int input){
        if(!policy.isAmountPositive(input)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() +
                    ExceptionMessage.INPUT_NUMBER_POSITIVE.getMessage());
        }
    }

}
