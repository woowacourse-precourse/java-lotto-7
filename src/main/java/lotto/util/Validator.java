package lotto.util;

import lotto.inputoutput.InputHandler;
import lotto.constants.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Validator {
    public static void validateInput(List<Integer> winningNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumber);
        if (uniqueNumbers.size() != winningNumber.size())
            throw new IllegalArgumentException();
    }

    public static void validateInput(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_NUMBER.getMessage());
        }
    }

    public static int checkBonusNumberDuplication(int bonus, List<Integer> winningNumber) {
        if (winningNumber.contains(bonus))
            throw new IllegalArgumentException();
        return bonus;
    }
    public static void validateLottoPrice(String input){
        if ( InputHandler.convertToInt(input) % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PRICE.getMessage());
    }
}