package lotto.domain;

import lotto.common.ErrorMessage;
import lotto.common.RegexPattern;

import java.util.List;

public class WinningNumbers {
    private static final Integer LOTTO_COUNTS=6;
    private static final Integer MININUM_NUMBER = 1;
    private static final Integer MAXIM1UM_NUMBER = 45;
    private final List<Integer> parsedNumbers;

    public WinningNumbers(List<Integer> parsedNumbers) {
        validateParsedNumbers(parsedNumbers);
        this.parsedNumbers=parsedNumbers;
    }

    public List<Integer> getParsedNumbers() {
        return parsedNumbers;
    }

    private void validateParsedNumbers(List<Integer> parsedNumbers) {
        validateLottoCount(parsedNumbers);
        validateDistinctLotto(parsedNumbers);
        validateLottoInRange(parsedNumbers);

    }

    private void validateDistinctLotto(List<Integer> parsedNumbers) {
        long distinctLotto=parsedNumbers.stream().distinct().count();

        if (parsedNumbers.size()!=distinctLotto){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER);
        }
    }

    private void validateLottoCount(List<Integer> parsedNumbers) {
        int lottoCount=parsedNumbers.size();

        if (lottoCount!=LOTTO_COUNTS){
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT);
        }
    }

    private void validateLottoInRange(List<Integer> parsedNumbers) {
        boolean haveOutOfRangeNumber=parsedNumbers.stream().
                anyMatch(number->(number<MININUM_NUMBER || number>MAXIM1UM_NUMBER));

        if (haveOutOfRangeNumber){
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }

    }



}
