package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static lotto.message.ErrorMessage.*;
import static lotto.util.LottoConfig.*;

public class ValidateNumbers {
    public ValidateNumbers(int number, List<Integer> winningNumbers){
        validateLottoRange(number);
        validateNoDuplicateBonus(number, winningNumbers);
    }
    public ValidateNumbers(List<Integer> winningNumbers){
        validateLottoLength(winningNumbers);
        validateNoDuplicateNumber(winningNumbers);
        for(Integer number: winningNumbers){
            validateLottoRange(number);
        }
    }
    private static void validateLottoRange(int number){
        if(number < LOTTO_MIN.getNumber() || number > LOTTO_MAX.getNumber()){
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
        }
    }
    private static void validateLottoLength(List<Integer> numbers){
        if(numbers.size() != LOTTO_LENGTH.getNumber()){
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH.getMessage());
        }
    }
    private static void validateNoDuplicateNumber(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException(INVALID_DUPLICATE_LOTTO.getMessage());
        }
    }
    private static void validateNoDuplicateBonus(int number, List<Integer> winningNumbers){
        if(winningNumbers.contains(number)){
            throw new IllegalArgumentException(INVALID_DUPLICATE_BONUS.getMessage());
        }
    }
}