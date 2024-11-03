package lotto;

import java.util.List;

public class InputValidator {
    public static final int LOTTO_UNIT = 1000;
    public static final int LOTTO_START = 1;
    public static final int LOTTO_END = 45;

    public static void validatePrice(int purchasePrice) {
        if (purchasePrice < LOTTO_UNIT || purchasePrice % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000이상, 1000원 단위여야 합니다.");
        }
    }

    public static void validLotto(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_START || number > LOTTO_END) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요!");
            }
        }
    }

    public static void validateBonus(List<Integer> winningNumber, int bonus) {
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 될수 없습니다.");
        }
    }

}