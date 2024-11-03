package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.*;

public class Validator {

    public void validateBudget(String number){
        isNullInputValue(number);
        isZeroBudget(number);
        int parseNumber = Parse.parseInteger(number);
        checkValidationBudget(parseNumber);
    }
    public void validateLottoNumbers(String lottoNumbers){
        isNullInputValue(lottoNumbers);
        invalidLottoNumberPattern(lottoNumbers);
        List<String> strings = Separator.separateLottoNumbers(lottoNumbers);
        checkInputLottoNumberValue(strings);
    }

    private void checkInputLottoNumberValue(List<String> strings) {
        for (String string : strings) {
            int parseNumber = Parse.parseInteger(string);
            validateIntegerRange(parseNumber);
        }
    }

    private void isNullInputValue(String number) {
        if(number.isEmpty() || number == null){
            throw new IllegalArgumentException(ERROR_PREFIX.getErrorMessage() + EMPTY_INPUT_VALUE_ERROR.getErrorMessage());
        }
    }

    private void isZeroBudget(String number){
        if(number.equals("0")){
            throw new IllegalArgumentException(ERROR_PREFIX.getErrorMessage()+ZERO_BUDGET_ERROR.getErrorMessage());
        }
    }

    private static void invalidLottoNumberPattern(String number) {
        if (!number.matches("\\d+(,\\d+)*")) {
            throw new IllegalArgumentException(ERROR_PREFIX.getErrorMessage() + INVALID_INPUT_LOTTO_STRING.getErrorMessage());
        }
    }

    private void checkValidationBudget(int number){
        if(!(number % 1000 == 0)){
            throw new IllegalArgumentException(ERROR_PREFIX.getErrorMessage() + INVALID_BUDGET.getErrorMessage());
        }
    }

    public void validateIntegerRange(int number){
        if(!(number>0 && number<46)){
            throw new IllegalArgumentException(ERROR_PREFIX.getErrorMessage()+INVALID_LOTTO_NUMBER.getErrorMessage());
        }
    }
}

