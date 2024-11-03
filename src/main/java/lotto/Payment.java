package lotto;

public class Price {
    private final int value;

    private Price(int value) {
        validate(value);
        this.value = value;
    }

    public static Price from(String input) {
        try {
            return new Price(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + "문자가 입력됐거나 숫자 범위를 초과하였습니다.");
        }
    }

    public int getValue() {
        return this.value;
    }

    private void validate(int value) {
        if(value > 100000) {
            throw new IllegalArgumentException("[ERROR] " + "로또 최대 구입 금액은 2,000,000,000원 입니다.");
        }
        if (value == 0 || value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] " + "로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
