package lotto;

public class PurchaseAmountValidator {
    public static int isInvalidPurchaseAmount(String inputPurchaseAmount){
        isNotEmpty(inputPurchaseAmount);
        int purchaseAmount = canParseToInt(inputPurchaseAmount);
        isNonPositiveNumber(purchaseAmount);
        canDividedByThousand(purchaseAmount);
        return purchaseAmount;
    }

    private static void isNotEmpty(String inputPurchaseAmount){
        if(inputPurchaseAmount == null || inputPurchaseAmount.isBlank()){
            throw new IllegalArgumentException("빈 값은 입력하실 수 없습니다.");
        }
    }

    private static int canParseToInt(String inputPurchaseAmount){
        try{
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하셔야 합니다.");
        }
    }

    private static void isNonPositiveNumber(int purchaseAmount){
        if(purchaseAmount <= 0){
            throw new IllegalArgumentException("양수를 입력하셔야 합니다.");
        }
    }

    private static void canDividedByThousand(int purchaseAmount){
        if(purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException("1,000원으로 나눠질 수 있는 금액을 입력하셔야 합니다.");
        }
    }
}
