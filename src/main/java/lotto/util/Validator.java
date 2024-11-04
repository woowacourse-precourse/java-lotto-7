package lotto.util;

import lotto.model.Lotto;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public static void validateIsNumeric(String input) {
        if (!input.matches("\\d+"))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자 형식이어야 합니다.");
    }

    public static void validateLottoRange(int number) {
        if (number < Constants.MIN_NUMBER || number > Constants.MAX_NUMBER)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
    }

    public static void validateIsDuplicate(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 번호입니다.");
    }

    public static void validateNotBlank(String input) {
        if (input.contains(" "))
            throw new IllegalArgumentException("[ERROR] 공백은 포함될 수 없습니다.");
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size())
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어 있습니다.");
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    public static void validateIsDivisible(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 원 단위의 값이어야 합니다.");
        }
    }

    public static void validateBelowMinimum(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000 원 이상의 값이어야 합니다.");
        }
    }
}
