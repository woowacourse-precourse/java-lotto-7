package lotto;

import java.util.List;

public class Validator {
    public static void checkValidPurchaseCount(int amount) {
        checkPositiveNumber(amount);

        if (amount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 입력이 1000으로 나누어 떨어지지 않습니다.");
    }

    public static void checkLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().toList().size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복되는 숫자가 있습니다.");
        }
    }

    public static void checkPositiveNumber(int number) {
        if (!(number > 0)) {
            throw new IllegalArgumentException("[ERROR] 양수가 아닙니다.");
        }
    }
}
