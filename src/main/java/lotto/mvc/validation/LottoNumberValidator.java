package lotto.mvc.validation;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberValidator {
    public static void isValid(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
        }

        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbers.split(",")) {
            number = number.trim();

            try {
                int winningNumber = Integer.parseInt(number);

                if (winningNumber < 1 || winningNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
                }

                if (winningNumbers.contains(winningNumber)) {
                    throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
                }

                winningNumbers.add(winningNumber);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
            }
        }

    }
}
