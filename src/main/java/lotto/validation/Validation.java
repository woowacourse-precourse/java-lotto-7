package lotto.validation;
import static lotto.domain.Constants.LOTTO_MAX;
import static lotto.domain.Constants.LOTTO_MIN;
import static lotto.domain.Constants.LOTTO_NUM_COUNT;
import static lotto.domain.Constants.LOTTO_PRICE;
import static lotto.domain.Constants.SPLIT;

import lotto.Lotto;

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

}
