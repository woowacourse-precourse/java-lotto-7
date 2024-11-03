package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int DIVISION_UNIT = 1000;

    public static void integerValidate(String string) {
        try {
            int value = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력된 값은 정수가 아닙니다.");
        }
    }

    public static void purchaseAmountValidate(int purchaseAmount) {
        if (purchaseAmount % DIVISION_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위입니다.");
        }
    }

    public static void winningNumbersValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다. ");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);

            if ((int) number != number || number <= 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45의 정수만 입력 가능합니다.");
            }

            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }

    }

    public static void bonusNumberValidate(int number, List<Integer> winningNumbers) {
        if ((int) number != number || number <= 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45의 정수만 입력 가능합니다.");
        }
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (number == winningNumbers.get(i)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복이 불가능합니다.");
            }
        }

    }

}
