package lotto.validate;

import java.util.Arrays;
import java.util.List;

public class ValidateInput {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static int validateAmount(String amountInput){
        try {
            int amount = Integer.parseInt(amountInput);
            if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력하셔야 합니다.");
        }
    }


    public static void validateWinningNumbers(List<Integer> winningNumbers){
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 중복되지 않는 숫자를 입력해야 합니다.");
        }

        for(int parsedNumber : winningNumbers){
            if (parsedNumber < MAX_NUMBER || parsedNumber > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다: " + parsedNumber);
            }
        }
    }



    public static int validateBonusNumber(String inputBonusNumber){
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("");
        }
        return bonusNumber;
    }
}
