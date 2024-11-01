package lotto.model;

public class Amount {
    private final int number;

    public Amount(int number) {
        validateUnit(number);
        this.number = number;
    }

    public static Amount of(String number) {
        return new Amount(validateType(number));
    }

    private void validateUnit(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매는 1000원 단위로 가능합니다.");
        }
    }

    private static int validateType(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 숫자로 입력해주세요.");
        }
    }

    public int getNumber() {
        return number;
    }
}
