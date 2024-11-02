package lotto;

public class Validator {
    public static void checkValidPurchaseCount(long amount) {
        if (!(amount > 0))
            throw new IllegalArgumentException("[ERROR] 양수가 아닙니다.");
        if (amount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 입력이 1000으로 나누어 떨어지지 않습니다.");
    }
}
