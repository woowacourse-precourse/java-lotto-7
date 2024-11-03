package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.*;

public class Validator {

    public static void validateBudget(String budget){
        isNullInputValue(budget);
        isZeroBudget(budget);
        int parseBudget = Parse.parseInteger(budget);
        checkValidationBudget(parseBudget);
    }
    private static void checkValidationBudget(int number){
        if(!(number % 1000 == 0)){
            throw new IllegalArgumentException(INVALID_BUDGET.getErrorMessage());
        }
    }
    public static void validateLottoNumbers(String lottoNumbers){
        isNullInputValue(lottoNumbers);
        invalidLottoNumberPattern(lottoNumbers);
        List<String> strings = Separator.separateLottoNumbers(lottoNumbers);
        checkInputLottoNumberValue(strings);
    }

    private static void checkInputLottoNumberValue(List<String> strings) {
        for (String string : strings) {
            int parseNumber = Parse.parseInteger(string);
            validateIntegerRange(parseNumber);
        }
    }

    private static void isNullInputValue(String number) {
        if(number.isEmpty() || number == null){
            throw new IllegalArgumentException(EMPTY_INPUT_VALUE_ERROR.getErrorMessage());
        }
    }

    private static void isZeroBudget(String number){
        if(number.equals("0")){
            throw new IllegalArgumentException(ZERO_BUDGET_ERROR.getErrorMessage());
        }
    }

    private static void invalidLottoNumberPattern(String number) {
        if (!number.matches("\\d+(,\\d+)*")) {
            throw new IllegalArgumentException(INVALID_INPUT_LOTTO_STRING.getErrorMessage());
        }
    }

    public static void validateIntegerRange(int number){
        if(!(number>0 && number<46)){
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getErrorMessage());
        }
    }
}

