package lotto.validation;
import static lotto.domain.Constants.LOTTO_MAX;
import static lotto.domain.Constants.LOTTO_MIN;
import static lotto.domain.Constants.LOTTO_PRICE;
import static lotto.domain.Constants.SPLIT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class Validation {
    public void purchase(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

    public void number(String input) throws IllegalArgumentException {
        String[] numbers = input.split(SPLIT);
        for (String number : numbers) {
            number = number.trim();  // 공백 제거
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
            }

            int num = Integer.parseInt(number);
            if (num < LOTTO_MIN || num > LOTTO_MAX) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 정수만 입력할 수 있습니다.");
            }
        }
    }


    public void duplicatedBonous(String input, List<Lotto> winningNumbers) {
        String[] numbers = input.split(SPLIT);
        Set<Integer> winningSet = new HashSet<>();
        for (Lotto lotto : winningNumbers) {
            winningSet.addAll(lotto.getNumbers());  // Lotto 객체의 번호 리스트를 Set에 추가
        }
        for (String number : numbers) {
            number = number.trim();
            int num = Integer.parseInt(number);
            if (winningSet.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호와 중복입니다: " + num);
            }
        }
    }

    public void duplicatedNumber(String input) {
        String[] numbers = input.split(SPLIT);
        Set<String> uniqueNumbers = new HashSet<>();

        for (String number : numbers) {
            number = number.trim();

            // 중복 검사
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 입력된 번호에 중복된 숫자가 있습니다: " + number);
            }
        }
    }
}
