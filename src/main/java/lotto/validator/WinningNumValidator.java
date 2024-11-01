package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static lotto.enums.Constants.*;
import static lotto.enums.ExceptionMessage.*;

public class WinningNumValidator extends Validator{
    @Override
    public void validate(String input) throws IllegalArgumentException {
        String[] lottoNums = input.split(",");
        validateNumberOfLottoNum(lottoNums);
        for (String lottoNum : lottoNums) {
            validateInt(lottoNum);
            validateRange(input);
        }
        validateDuplicate(lottoNums);
    }

    public void validateDuplicate(String[] input) {
        Set lottoNums = new HashSet<>(Arrays.asList(input));
        if (lottoNums.size() != NUMBER_OF_LOTTO_NUMBERS.getValue()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUM_DUPLICATE.getMessage());
        }
    }
    public void validateNumberOfLottoNum(String[] input) {
        if (input.length!= NUMBER_OF_LOTTO_NUMBERS.getValue()){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_WINNING_NUMBERS.getMessage());
        }
    }

}
