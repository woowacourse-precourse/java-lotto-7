package lotto;

import java.util.List;

public class InputValidator {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_PRICE_UNIT = 1000;

    public static void validateNumericNumber(String input){
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
            }
        }
    }

    public static void validateThousandUnit(int purchaseNumber){
        if(purchaseNumber % LOTTO_PRICE_UNIT!= 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    public static void validateNotDuplicate(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public static void validateEmptyInput(String input){
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있을 수 없습니다.");
        }
    }

    public static void validateBonusNumber(String input){
        try {
            Integer.valueOf(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    public static void validateBonusNumberRange(int bonusNumber){
        if(bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 이내의 숫자만 입력 가능합니다.");
        }
    }
}
