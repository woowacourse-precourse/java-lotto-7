package lotto.model.draw;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber from(String input) {
        String stripped = input.strip();
        validateEmpty(input);
        validateNumeric(stripped);
        int number = Integer.parseInt(stripped);
        return new BonusNumber(number);
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 빈 값입니다.");
        }
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    private void validate(int number) {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void checkDuplicationNumber(WinningLotto winningLotto) {
        if (winningLotto.isContain(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 되지 않는 숫자여야 합니다.");
        };
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number+"";
    }
}
