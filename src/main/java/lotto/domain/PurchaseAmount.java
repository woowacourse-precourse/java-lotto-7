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

import lotto.constant.Constant;
import lotto.constant.ErrorMessage;

public class PurchaseAmount {
    private final double purchaseAmount;

    public PurchaseAmount(double purchaseAmount) {
        validateUnit(purchaseAmount);
        validateMax(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateMax(double purchaseAmount) {
        if (purchaseAmount > Constant.MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_MAX_ERROR_MESSAGE);
        }
    }

    private void validateUnit(double purchaseAmount) {
        if(purchaseAmount % Constant.UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNIT_DIVISIBLE_ERROR_MESSAGE);
        }
    }

    public int getNumberOfLotto() {
        return (int) (purchaseAmount / Constant.UNIT);
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }
}
