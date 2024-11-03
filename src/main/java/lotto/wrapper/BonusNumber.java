package lotto.wrapper;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public static BonusNumber of(int number) {
        return new BonusNumber(number);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

}
