package lotto.validation;

import static lotto.domain.Constants.LOTTO_MAX;
import static lotto.domain.Constants.LOTTO_MIN;
import static lotto.domain.Constants.LOTTO_PRICE;
import static lotto.domain.Constants.SPLIT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public void purchase(String amount) {
        try {
            int parsedAmount = Integer.parseInt(amount.trim());  // 문자열을 정수로 변환
            if (parsedAmount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자 형식으로 입력해야 합니다.");
        }
    }

    public void number(String input) throws IllegalArgumentException {
        String[] numbers = input.split(SPLIT);
        for (String number : numbers) {
            number = number.trim();
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
            }

            int num = Integer.parseInt(number);
            if (num < LOTTO_MIN || num > LOTTO_MAX) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 정수만 입력할 수 있습니다.");
            }
        }
    }

    public void duplicatedBonous(String input, List<Integer> winningNumbers) {
        String[] numbers = input.split(SPLIT);
        Set<Integer> winningSet = new HashSet<>(winningNumbers);

        for (String number : numbers) {
            number = number.trim();
            int num = Integer.parseInt(number);
            if (winningSet.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호와 중복입니다: " + num);
            }
        }
    }
}
