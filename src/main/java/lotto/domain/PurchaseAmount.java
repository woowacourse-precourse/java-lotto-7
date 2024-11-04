package lotto.domain;

import lotto.view.ErrorMessage;

public class PurchaseAmount {
    private static final int UNIT = 1000;
    private final int amountNum;
    public PurchaseAmount(String amountStr){
        int amount=checkText(amountStr);
        validate(amount);
        this.amountNum=amount;
    }
    private void validate(int amount) {
        checkNegative(amount);
        checkUnit(amount);
    }
    private static int checkText(String amountStr) {
        amountStr=amountStr.trim();
        if (amountStr.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_AMOUNT.getMessage());
        }
        try {
            return Integer.parseInt(amountStr.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
    private void checkNegative(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER_ERROR.getMessage());
        }
    }
    private void checkUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_NUMBER_ERROR.getMessage());
        }
    }
    public int calculateLottoCount(){
        return amountNum/UNIT;
    }
    public int getAmountNum() {
        return amountNum;
    }
}
