package lotto.validator;

public class PurchaseAmountValidator {
    public static int parseAmount(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다.");
        }
    }

    public static void validateAmount (int amount){
        if (amount%1000 != 0){
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
