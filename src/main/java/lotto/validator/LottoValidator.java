package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    public static void validatePrice(String input) {
        try {
            int Price = Integer.parseInt(input);
            if (Price % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자이어야 합니다.");
        }
    }
    public static void validateWinningNumbers(List<Integer> numbers, int bonusNumber){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        if (uniqueNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }
}
