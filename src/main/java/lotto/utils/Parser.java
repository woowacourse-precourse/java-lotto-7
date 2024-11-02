package lotto.utils;

public class Parser {
    public static long stringToLong(String purchaseAmount) {
        try {
            return Long.parseLong(purchaseAmount.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
        }
    }
}
