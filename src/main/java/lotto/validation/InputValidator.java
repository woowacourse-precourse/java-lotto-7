package lotto.validation;

import lotto.constant.Constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean isThousandUnit(int input) {
        return input % Constants.THOUSAND_UNIT == Constants.ZERO;
    }

    public static boolean isValidFormatForMoney(String input) {
        return input.matches(Constants.MONEY_REGEX);
    }

    public static boolean isValidFormatForLottoNumber(String input) {
        return input.matches(Constants.LOTTO_REGEX);
    }

    public static boolean isCountSix(String[] input) {
        return input.length == Constants.MAX_LOTTO_COUNT;
    }

    public static boolean isUniqueNumbers(String[] numbers) {
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));

        return uniqueNumbers.size() == numbers.length;
    }

    public static boolean isInRange(String[] numbers) {

        for (String number : numbers) {

            if (!isValidNumber(number)) {
                return false;
            }
        }
        return true;
    }


    public static boolean isInRange(String number) {
        return isValidNumber(number);
    }

    private static boolean isValidNumber(String number) {

        try {
            int num = Integer.parseInt(number);
            return num >= Constants.MIN_LOTTO_RANGE && num <= Constants.MAX_LOTTO_RANGE;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumeric(String number) {
        return number.matches(Constants.NUMBER_REGEX);
    }

    public static boolean isUnique(String number, List<Integer> lottoNumbers) {
        int bonusNumber = Integer.parseInt(number);

        for (int lottoNumber : lottoNumbers) {

            if (lottoNumber == bonusNumber) {
                return false;
            }
        }
        return true;
    }
}
