/*
 * 클래스 이름 PurchaseAmount
 *
 * 버전 정보 V1
 *
 * 날짜 10월 31일
 *
 * 저작권 주의
 */
package lotto.domain;

import lotto.constant.ErrorMessage;

public class PurchaseAmount {
    private static final double UNIT = 1000.0;
    private static final double MAX_PURCHASE_AMOUNT = 100000000.0;
    private final double purchaseAmount;

    public PurchaseAmount(String purchaseAmount) {
        double amount = 0;
        try {
            amount= Double.parseDouble(purchaseAmount);
        }catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.READ_NUMBER_ERROR_MESSAGE);
        }
        validateUnit(amount);
        validateMax(amount);
        this.purchaseAmount = amount;
    }

    private void validateMax(double purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_MAX_ERROR_MESSAGE);
        }
    }

    private void validateUnit(double purchaseAmount) {
        if(purchaseAmount % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNIT_DIVISIBLE_ERROR_MESSAGE);
        }
    }

    public int getNumberOfLotto() {
        return (int) (purchaseAmount / UNIT);
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }
}
