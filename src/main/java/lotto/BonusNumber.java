package lotto;

import java.util.List;

public class BonusNumber {
    private final int value;

    private BonusNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static BonusNumber from(String input) {
        try {
            validate(input);
            int value = Integer.parseInt(input);
            return new BonusNumber(value);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + "문자가 입력됐거나 숫자 범위를 초과하였습니다.");
        }
    }

    private static void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] " + "보너스 번호가 null이어서는 안 됩니다.");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] " + "보너스 번호가 빈 문자여서는 안 됩니다.");
        }
    }

    public int getValue() {
        return this.value;
    }

    public void isDuplicated(WinningNumber winningNumber) {
        if(winningNumber == null) {
            throw new IllegalArgumentException("[ERROR] " + "당첨 번호가 null이어서는 안 됩니다.");
        }
        List<Integer> winningNumbers = winningNumber.getNumbers();
        for (Integer number : winningNumbers) {
            if(number == this.value) {
                throw new IllegalArgumentException("[ERROR] " + "당첨 번호와 보너스 번호가 같아서는 안 됩니다.");
            }
        }
    }

    private static void validate(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] " + "보너스 번호는 1에서 45 사이여야 합니다.");
        }
    }
}
