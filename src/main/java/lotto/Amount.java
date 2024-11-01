package lotto;

public class Amount {
    private final int number;

    public Amount(int number) {
        validateUnit(number);
        this.number = number;
    }

    private void validateUnit(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매는 1000원 단위로 가능합니다.");
        }
    }
}
