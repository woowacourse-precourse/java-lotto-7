package lottoWinningNumber;

import java.util.List;

public class LottoWinningNumberValidator {
    private final static String ERROR_TEXT_INFRONT_OF_DETAILS = "[ERROR] ";
    private final static String RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_WINNING_NUMBER = "로또 우승 번호로 1부터 45까지 중복되지 않는 숫자 6개를 콤마(,)를 이용해서 구별해서 입력해주세요. ex) 1,2,3,4,5,6";
    private final static int AMOUNT_OF_LOTTO_NUMBERS = 6;
    private final static int MINIMUM_LOTTO_NUMBER = 1;
    private final static int MAXIMUM_LOTTO_NUMBER = 45;
    private final static IllegalArgumentException EXCEPTION_LOTTO_WINNING_NUMBER = new IllegalArgumentException(
            ERROR_TEXT_INFRONT_OF_DETAILS + RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_WINNING_NUMBER);

    public void validateAllThing(List<String> seperatedLottoWinningNumbers) {
        // 문자열로 할 수 있는 것
        validateAmountOfNumbersIs6(seperatedLottoWinningNumbers);
        validateNumbersOverlap(seperatedLottoWinningNumbers);
        // 숫자로 할 수 있는 것
        validateNumbersAreNumeric(seperatedLottoWinningNumbers);
        validateRangeOfNumbersGreaterThan1AndLessThan45(seperatedLottoWinningNumbers);
    }

    private void validateAmountOfNumbersIs6(List<String> seperatedLottoWinningNumbers) {
        if (seperatedLottoWinningNumbers.size() != AMOUNT_OF_LOTTO_NUMBERS) {
            throw EXCEPTION_LOTTO_WINNING_NUMBER;
        }
    }

    private void validateNumbersOverlap(List<String> seperatedLottoWinningNumbers) {
        List<String> deleteOverlapSeperatedLottoWinningNumbers = seperatedLottoWinningNumbers.stream().distinct()
                .toList();

        if (deleteOverlapSeperatedLottoWinningNumbers.size() != seperatedLottoWinningNumbers.size()) {
            throw EXCEPTION_LOTTO_WINNING_NUMBER;
        }
    }

    // numberFormatException 외 다른 exception 존재?
    private void validateNumbersAreNumeric(List<String> seperatedLottoWinningNumbers) {
        try {
            convertToCompareNumbers(seperatedLottoWinningNumbers);
        } catch (NumberFormatException numberFormatException) {
            throw EXCEPTION_LOTTO_WINNING_NUMBER;
        }
    }

    private void validateRangeOfNumbersGreaterThan1AndLessThan45(List<String> seperatedLottoWinningNumbers) {
        List<Integer> seperatedLottoWinningNumbersToInt = convertToCompareNumbers(seperatedLottoWinningNumbers);

        if (!isAllNumbersThatFitConditions(seperatedLottoWinningNumbersToInt)) {
            throw EXCEPTION_LOTTO_WINNING_NUMBER;
        }
    }

    private boolean isAllNumbersThatFitConditions(List<Integer> seperatedLottoWinningNumbersToInt) {
        return seperatedLottoWinningNumbersToInt.stream().allMatch(
                seperatedLottoWinningNumberToInt -> seperatedLottoWinningNumberToInt >= MINIMUM_LOTTO_NUMBER
                        && seperatedLottoWinningNumberToInt <= MAXIMUM_LOTTO_NUMBER);
    }

    public List<Integer> convertToCompareNumbers(List<String> seperatedLottoWinningNumbers) {
        List<Integer> convertedWinningNumbersToCompare = seperatedLottoWinningNumbers.stream().mapToInt(Integer::parseInt).boxed()
                .toList();

        // 이름 바꿔야 함.
        return convertedWinningNumbersToCompare;
    }
}
