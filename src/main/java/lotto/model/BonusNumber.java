package lotto.model;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1이상 45이하의 숫자여야 합니다.");
        }
    }
}
