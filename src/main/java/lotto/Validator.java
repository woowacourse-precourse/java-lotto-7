package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateWinNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하만 가능합니다.");
            }
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateBonusNumber(List<Integer> winNumbers, int bonusNumber) {
        if (1 > bonusNumber || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 보너스 로또 번호는 1이상 45이하의 숫자만 가능합니다.");
        }
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validatePurchaseNumber(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원단위로 입력가능합니다.");
        }
    }
}
