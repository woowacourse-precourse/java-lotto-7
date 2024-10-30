package lotto.util;

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
}
