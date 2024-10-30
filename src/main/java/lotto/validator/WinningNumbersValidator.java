package lotto.validator;

import lotto.common.CommonValidator;
import lotto.common.ErrorMessage;
import lotto.common.RegexPattern;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {
    private static final String INPUT_SEPERATOR=",";
    private static final Integer LOTTO_COUNTS=6;
    private static final Integer MININUM_NUMBER = 1;
    private static final Integer MAXIM1UM_NUMBER = 45;

    public static List<Integer> validateWinningNumbers(String input){
        CommonValidator.validateNullAndBlank(input);
        validateOnyIntegerAndComma(input);

        List<Integer> winningNumbers= Arrays.stream(input.split(INPUT_SEPERATOR))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());

        validateEachLotto(winningNumbers);

        return winningNumbers;

    }

    private static void validateOnyIntegerAndComma(String input) {
        if (!RegexPattern.ONLY_INTEGER_AND_COMMA.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_CHARACTER);
        }
    }

    private static void validateEachLotto(List<Integer> winningNumbers) {
        validateDistinctLotto(winningNumbers);
        validateLottoInRange(winningNumbers);
        validateLottoCount(winningNumbers);
    }

    private static void validateLottoCount(List<Integer> winningNumbers) {
        int lottoCount=winningNumbers.size();

        if (lottoCount!=LOTTO_COUNTS){
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT);
        }
    }

    private static void validateLottoInRange(List<Integer> winningNumbers) {
        boolean haveOutOfRangeNumber=winningNumbers.stream().
                anyMatch(number->(number<MININUM_NUMBER || number>MAXIM1UM_NUMBER));

        if (haveOutOfRangeNumber){
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }

    private static void validateDistinctLotto(List<Integer> winningNumbers) {
        long distinctLotto=winningNumbers.stream().distinct().count();

        if (winningNumbers.size()!=distinctLotto){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER);
        }
    }


}
