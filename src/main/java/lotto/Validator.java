package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validatePurchaseAmount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0 || amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }

	public static void validateWinningNumbers(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        Set<Integer> numberSet = new HashSet<>();
        for (String numStr : numbers) {
            if (!numStr.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
            int num = Integer.parseInt(numStr);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!numberSet.add(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }
        }
    }

}