package lotto.validation;

public class InputValid {
    public static int checkInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다.");
        }
    }

    public static int checkMoney(String input) throws IllegalArgumentException {
        int m = checkInt(input);
        if(m%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000으로 나누어 떨어져야 합니다.");
        }
        if(m <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0이 아닌 값이어야 합니다.");
        }
        return m;
    }
}
