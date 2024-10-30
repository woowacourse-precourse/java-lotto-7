package lotto.validator;

public class PurchaseAmountValidator {

    private int purchaseAmount = 0;

    public boolean isNotValidPurchaseAmount(String userInput) {
        if (isNotParsableToPurchaseAmount(userInput)) {
            return true;
        }
        if (canNotPurchase(purchaseAmount)) {
            return true;
        }
        return false;
    }

    private boolean isNotParsableToPurchaseAmount(String userInput) {
        try {
            purchaseAmount = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 숫자형식을 입력해 주세요.");
            return true;
        }
        return false;
    }

    private boolean canNotPurchase(int purchaseAmount) {
        try {
            if (purchaseAmount < 1000 || (purchaseAmount % 1000) != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또는 1000원 부터 1000원 단위로 구매 가능합니다.");
            return true;
        }
        return false;
    }
}
