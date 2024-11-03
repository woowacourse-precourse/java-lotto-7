package lotto.validator;

import lotto.model.Lotto;

public class PurchaseValidator {
    private static final int MAX_PURCHASE_AMOUNT = 1_000_000_000;

    public boolean validatePurchaseMoney(String purchaseAmount) {
        try {
            purchaseAmount = purchaseAmount.replaceAll(" ", "");
            isEmptyPurchaseMoney(purchaseAmount);
            isNumberPurchaseMoney(purchaseAmount);
            checkPurchaseAmountRange(purchaseAmount);
            isThousandUnitPurchaseMoney(Integer.parseInt(purchaseAmount));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void checkPurchaseAmountRange(String purchaseAmount) {
        try {
            if (Integer.parseInt(purchaseAmount) > MAX_PURCHASE_AMOUNT) {
                throw new IllegalArgumentException("[ERROR] 구매 가능 금액은 최대 10억입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 가능 금액은 최대 10억입니다.");
        }
    }

    private void isNumberPurchaseMoney(String purchaseAmount) {
        if (!purchaseAmount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 음수, 숫자 이외의 값은 입력하실 수 없습니다.");
        }
    }

    private void isEmptyPurchaseMoney(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액을 입력해주세요.");
        }
    }

    private void isThousandUnitPurchaseMoney(int purchaseAmount) {
        if (0 != (purchaseAmount % Lotto.PRICE) || purchaseAmount < Lotto.PRICE) {
            throw new IllegalArgumentException("[ERROR] 최소 천원 이상, 천원 단위로 입력해주세요.");
        }
    }
}

