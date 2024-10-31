package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static lotto.message.ErrorMessage.*;

public class ValidateNumbers {
    private static final int MIN_LOTTO = 1;
    private static final int MAX_LOTTO = 45;
    private static final int LOTTO_LENGTH = 6;
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
        if(number < MIN_LOTTO || number > MAX_LOTTO){
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
        }
    }
    private static void validateLottoLength(List<Integer> numbers){
        if(numbers.size() != LOTTO_LENGTH){
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