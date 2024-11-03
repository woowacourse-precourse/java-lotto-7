package lotto.wrapper;

public class BonusNumber {

    private final int number;

    private BonusNumber(String inputNumber) {
        int number = validateType(inputNumber);
        validateRange(number);
        this.number = number;
    }

    public static BonusNumber of(String inputNumber) {
        return new BonusNumber(inputNumber);
    }

    private int validateType(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
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
