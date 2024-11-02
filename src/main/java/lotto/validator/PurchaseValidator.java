package lotto.validator;

public class PurchaseValidator {

    private static final int lottoPrice = 1000;

    public boolean validatePurchaseAmount(String purchaseAmount) {
        try {
            isEmptyPurchaseAmount(purchaseAmount);
            purchaseAmount = purchaseAmount.replaceAll(" ", "");
            isRightPurchaseAmount(purchaseAmount);
            isRightPurchasePrice(Integer.parseInt(purchaseAmount));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void isRightPurchaseAmount(String purchaseAmount) {
        if (!purchaseAmount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[Error] 음수, 숫자 이외의 값은 입력하실 수 없습니다.");
        }
    }

    private void isEmptyPurchaseAmount(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException("[Error] 구매 금액을 입력해주세요.");
        }
    }

    private void isRightPurchasePrice(int purchaseAmount) {
        if (0 != (purchaseAmount % lottoPrice) || purchaseAmount < lottoPrice) {
            throw new IllegalArgumentException("[Error] 최소 천원 이상, 천원 단위로 입력해주세요.");
        }
    }
}

