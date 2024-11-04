package lotto;

public class InputValidator {
    public static void validatePurchase(String input){
        if(!input.matches("\\d+")){
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여아합니다.");
        }
        int amount = Integer.parseInt(input);
        if(amount < 1000 || amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }
}
