package lotto.domain;

import lotto.util.ValidatorUtils;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(String inputPurchaseAmount) {
        ValidatorUtils.isNotEmpty(inputPurchaseAmount);
        purchaseAmount = isInvalidPurchaseAmount(ValidatorUtils.canParseToInt(inputPurchaseAmount));
    }

    private int isInvalidPurchaseAmount(int purchaseAmount){
        isNonPositiveNumber(purchaseAmount);
        canDividedByThousand(purchaseAmount);
        return purchaseAmount;
    }

    private void isNonPositiveNumber(int purchaseAmount){
        if(purchaseAmount <= 0){
            throw new IllegalArgumentException("양수를 입력하셔야 합니다.");
        }
    }

    private void canDividedByThousand(int purchaseAmount){
        if(purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException("1,000원으로 나눠질 수 있는 금액을 입력하셔야 합니다.");
        }
    }

    public int findLottoCounts(){
        return this.purchaseAmount/1000;
    }
}
