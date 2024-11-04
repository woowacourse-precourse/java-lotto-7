package lotto.model;

import java.util.HashSet;
import java.util.Set;

public class CustomException extends Exception {
    private final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private final int PURCHASE_AMOUNT_UNIT = 1000;
    private final int REQUIRED_NUMBER_COUNT = 6;
    private final String DELIMITER = ",";
    private final int MIN = 1;
    private final int MAX = 45;
    private static final CustomException instance = new CustomException();
    private CustomException() {}
    public static CustomException getInstance() {
        return instance;
    }

    public void purchaseAmountInputCheck(String purchase){
        int amount = purchaseOnlyIntCheck(purchase);
        purchaseAmountCheck(amount);
    }

    public void winningNumberInputCheck(String inputWinningNumbers){
        String[] winningNumbers = winningNumberCountCheck(inputWinningNumbers);
        winningNumberRuleCheck(winningNumbers);
    }

    public void bonusNumberInputCheck(String inputBonusNumber){
        int bonusNumber = bonusNumberOnlyIntCheck(inputBonusNumber);
        bonusNumberRangeCheck(bonusNumber);
    }

    private int purchaseOnlyIntCheck(String purchase) {
        try {
            return Integer.parseInt(purchase);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력해주세요.");
        }
    }
    private void purchaseAmountCheck(int amount){
        if(amount < MINIMUM_PURCHASE_AMOUNT){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 "+MINIMUM_PURCHASE_AMOUNT+"원 이상이어야 합니다.");
        }
        if(amount % PURCHASE_AMOUNT_UNIT != 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 "+PURCHASE_AMOUNT_UNIT+"원 단위로 입력해주세요.");
        }
    }
    private String[] winningNumberCountCheck(String inputWinningNumbers){
        String[] numberStrings = inputWinningNumbers.split(",");
        if (numberStrings.length != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] "+REQUIRED_NUMBER_COUNT+"개의 숫자를 "+DELIMITER+"로 구분하여 입력해주세요.");
        }
        return numberStrings;
    }
    private void winningNumberRuleCheck(String[] winningNumbers){
        Set<Integer> winningNumberSet = new HashSet<>();
        try {
            for (String numberString : winningNumbers) {
                int number = Integer.parseInt(numberString.trim());
                if (number < MIN || number > MAX) {
                    throw new IllegalArgumentException("[ERROR] 각 번호는 " + MIN + "부터 " + MAX + " 사이의 숫자여야 합니다.");
                }
                if (!winningNumberSet.add(number)) {
                    throw new IllegalArgumentException("[ERROR] 각 번호는 중복될 수 없습니다.");
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자만 입력해야 합니다.");
        }
    }
    private int bonusNumberOnlyIntCheck(String inputBonusNumber){
        try{
            return Integer.parseInt(inputBonusNumber);
        }catch(NumberFormatException e){
            System.out.println("[ERROR] 당첨 보너스 번호는 숫자 1개만 입력 가능합니다.");
        }
        return 0;
    }
    private void bonusNumberRangeCheck(int bounsNumber){
        if(bounsNumber < MIN || bounsNumber > MAX){
            throw new IllegalArgumentException("[ERROR] 당첨 보너스 번호는 "+MIN+"이상 "+MAX+"이하 의 숫자만 가능합니다");
        }
    }
}
