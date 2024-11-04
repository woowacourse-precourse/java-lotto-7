package lotto.lottoMachine.lottoWinningNumber;

import java.util.List;
import lotto.lottoMachine.utils.StaticFinalMessages;

public class LottoWinningNumberValidator {

    public boolean validateAllThing(List<String> seperatedLottoWinningNumbers) {
        return validateAmountOfNumbersIs6(seperatedLottoWinningNumbers) && validateNumbersOverlap(
                seperatedLottoWinningNumbers) && validateNumbersAreNumeric(seperatedLottoWinningNumbers)
                && validateRangeOfNumbersGreaterThan1AndLessThan45(seperatedLottoWinningNumbers);
    }

    private boolean validateAmountOfNumbersIs6(List<String> seperatedLottoWinningNumbers) {
        return seperatedLottoWinningNumbers.size() == StaticFinalMessages.AMOUNT_OF_LOTTO_NUMBERS;
    }

    private boolean validateNumbersOverlap(List<String> seperatedLottoWinningNumbers) {
        List<String> deleteOverlapSeperatedLottoWinningNumbers = seperatedLottoWinningNumbers.stream().distinct()
                .toList();

        return deleteOverlapSeperatedLottoWinningNumbers.size() == seperatedLottoWinningNumbers.size();
    }

    // numberFormatException 외 다른 exception 존재?
    private boolean validateNumbersAreNumeric(List<String> seperatedLottoWinningNumbers) {
        try {
            convertToCompareNumbers(seperatedLottoWinningNumbers);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private boolean validateRangeOfNumbersGreaterThan1AndLessThan45(List<String> seperatedLottoWinningNumbers) {
        List<Integer> seperatedLottoWinningNumbersToInt = convertToCompareNumbers(seperatedLottoWinningNumbers);

        return isAllNumbersThatFitConditions(seperatedLottoWinningNumbersToInt);
    }

    private boolean isAllNumbersThatFitConditions(List<Integer> seperatedLottoWinningNumbersToInt) {
        return seperatedLottoWinningNumbersToInt.stream().allMatch(
                seperatedLottoWinningNumberToInt ->
                        seperatedLottoWinningNumberToInt >= StaticFinalMessages.MINIMUM_LOTTO_NUMBER
                                && seperatedLottoWinningNumberToInt <= StaticFinalMessages.MAXIMUM_LOTTO_NUMBER);
    }

    public List<Integer> convertToCompareNumbers(List<String> seperatedLottoWinningNumbers) {
        List<Integer> convertedWinningNumbersToCompare = seperatedLottoWinningNumbers.stream()
                .mapToInt(Integer::parseInt).boxed()
                .toList();

        // 이름 바꿔야 함.
        return convertedWinningNumbersToCompare;
    }
}
