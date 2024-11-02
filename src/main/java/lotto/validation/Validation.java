package lotto.validation;

import java.util.HashSet;
import java.util.List;

import static lotto.validation.ErrorMessage.*;

public class Validation {

    public static void checkInputTypeNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(LOTTO_ERROR_ONLY_NUMBER.getMessage());
        }
    }

    public static void checkInputTypeNumbers(String number) {
        String[] splitNumber = number.split(",");
        for (String num : splitNumber) {
            if (!num.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(LOTTO_ERROR_ONLY_NUMBER.getMessage());
            }
        }
    }

    public static void checkLottoSize(List<Integer> lottoNumbers, Integer maxLength) {
        if (lottoNumbers.size() != maxLength) {
            throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_SIZE.getMessage());
        }
    }

    public static void checkLottoDuplicate(List<Integer> numbers) {
        HashSet<Integer> checkNumber = new HashSet<>(numbers);
        if (checkNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_DUPLICATE.getMessage());
        }
    }

    public static void checkLottoNumberRange(int start, int end, List<Integer> numbers) {
        for (Integer number : numbers) {
            if (start > number || number > end) {
                throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_RANGE.getMessage());
            }
        }
    }

    public static void checkDuplicateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_DUPLICATE.getMessage());
        }
    }
    public static void checkMoneyMinCost(int money, int min_cost) {
        if (money < min_cost) {
            throw new IllegalArgumentException(LOTTO_ERROR_PAY_UNDER.getMessage());
        }
    }

    public static void checkMoneyMaxCost(int money, int max_cost) {
        if (money > max_cost) {
            throw new IllegalArgumentException(LOTTO_ERROR_PAY_OVER.getMessage());
        }
    }


}
