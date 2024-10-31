package lotto.util;

import java.util.List;

public class InputValidator {
    public static void validateRange(int number) {
        if (number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 최대값은 45 이하여야 합니다.");
        }
        if(number < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 최소값은 1 이상이어야 합니다.");
        }
    }

    public static void canDividedByThousand(long purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
    }

    public static void isNotNegativeNumber(long purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
        }
    }

    public static void isNotNumber(List<String> numbers) {
        try {
            numbers.forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 로또 번호는 숫자여야 합니다.");
        }
    }

    public static void isNotNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
