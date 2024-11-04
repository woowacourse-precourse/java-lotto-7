package lotto.util;

import lotto.collection.WinningNumber;
import lotto.exception.ValidatorException;

import java.util.Arrays;
import java.util.List;

public class Validator {

    // 구입 금액 검사
    public static void checkPurchasePrice(String value) {
        validatePurchasePrice(value);
    }

    private static void validatePurchasePrice(String value) {
        ValidatorException.throwIfValueIsNotNumber(value);
        ValidatorException.throwIfPurchasePriceNotMatchToUnit(value);
    }

    // 로또 검사
    public static void checkLottoTickets(List<Integer> lottoTickets) {
        validateLottoTickets(lottoTickets);
    }

    private static void validateLottoTickets(List<Integer> numbers) {
        ValidatorException.throwIfValuesIsMismatch(numbers);
        ValidatorException.throwIfValuesIsDuplicate(numbers);
        ValidatorException.throwIfNumbersAreOutOfRange(numbers);
    }

    // 당첨 번호 검사
    public static void checkWinningNumbers(String[] values) {
        validateWinningNumbers(values);
    }

    private static void validateWinningNumbers(String[] values) {
        for(String value : values) {
            ValidatorException.throwIfValueIsNotNumber(value);
            ValidatorException.throwIfValueIsOutOfRange(value);
        }
        List<Integer> integerValues = convertToIntegerList(values);

        ValidatorException.throwIfValuesIsMismatch(integerValues);
        ValidatorException.throwIfValuesIsDuplicate(integerValues);
    }

    private static List<Integer> convertToIntegerList(String[] values) {
        return Arrays.stream(values)
                .map(Integer::parseInt)
                .toList();
    }

    // 보너스 번호 검사
    public static void checkBonusNumber(WinningNumber winningNumbers, String bonusNumber) {
        validateBonusNumber(winningNumbers,bonusNumber);
    }

    private static void validateBonusNumber(WinningNumber winningNumbers, String bonusNumber) {
        ValidatorException.throwIfValueIsNotNumber(bonusNumber);
        ValidatorException.throwIfValueIsOutOfRange(bonusNumber);
        ValidatorException.throwIfBonusNumberIsDuplicate(winningNumbers,bonusNumber);
        ValidatorException.throwIfValueIsOutOfRange(bonusNumber);
    }

}
