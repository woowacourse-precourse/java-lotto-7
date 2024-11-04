package validator;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public static void validateInsertMoney(int insertMoney) {
        final int LOTTERY_PRIZE = 1_000;
        final int MINIMUM_VALUE = 0;
        if (insertMoney % LOTTERY_PRIZE > MINIMUM_VALUE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위 입니다.");
        } else if (insertMoney < LOTTERY_PRIZE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원을 넘어야 합니다");
        }
    }

    public static void validateWinNumbers(String numbers) {
        final int NUMBERS_COUNT = 6;
        final int NUMBER_LIMIT = 45;
        List<Integer> winNumbers = new ArrayList<>();
        for (String number : numbers.split(",")) {
            winNumbers.add(Integer.parseInt(number));
        }
        if (winNumbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 숫자는 6개 입니다.");
        }
        for (Integer number : winNumbers) {
            if (number > NUMBER_LIMIT) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호가 45를 넘어가면 안됩니다.");
            }
        }
    }

    public static void validateBonusNumber(int number) {
        final int MAXIMUM_NUMBER = 45;
        final int MINIMUM_NUMBER = 1;
        if (number > MAXIMUM_NUMBER || number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45 입니다.");
        }
    }
}
