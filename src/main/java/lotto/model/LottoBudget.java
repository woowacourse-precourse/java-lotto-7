package lotto.model;

public class LottoBudget {
    private final int value;

    public LottoBudget(String lottoBudgetString) {
        int value = parseInput(lottoBudgetString);
        validateValue(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
    }

    private void validateValue(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }

        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 양수여야 합니다.");
        }
    }

    public int getLottoCount() {
        return value / 1000;
    }
}
