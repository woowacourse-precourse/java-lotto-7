package lotto;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
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
}
