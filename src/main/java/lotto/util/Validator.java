package lotto.util;

import lotto.model.Lotto;

public class Validator {

    public static void validateIsNumeric(String input) {
        if (!input.matches("\\d+"))
            throw new IllegalArgumentException("로또 번호는 숫자 형식이어야 합니다.");
    }

    public static void validateLottoRange(int number) {
        if (number < Constants.MIN_NUMBER || number > Constants.MAX_NUMBER)
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 숫자여야 합니다.");
    }

    public static void validateIsDuplicate(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("당첨 번호와 중복된 번호입니다.");
    }

    public static void validateNotBlank(String input) {
        if (input.contains(" "))
            throw new IllegalArgumentException("공백은 포함될 수 없습니다.");
    }
}
