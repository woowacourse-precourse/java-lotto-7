package lotto.domain;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber from(String input) {
        try {
            int number = Integer.parseInt(input);
            return new BonusNumber(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validate(int number) {
        if (isInvalidRange(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isInvalidRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
