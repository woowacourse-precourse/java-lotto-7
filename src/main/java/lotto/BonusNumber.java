package lotto;

import java.util.List;

public class BonusNumber {
    private final int value;

    private BonusNumber(int value) {
        this.value = value;
    }

    public static BonusNumber from(String input, WinningNumber winningNumber) {
        try {
            int value = Integer.parseInt(input);
            validate(value, winningNumber);
            return new BonusNumber(value);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + "문자가 입력됐거나 숫자 범위를 초과하였습니다.");
        }
    }

    public int getValue() {
        return this.value;
    }

    private static void validate(int value, WinningNumber winningNumber) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] " + "보너스 번호는 1에서 45 사이여야 합니다.");
        }
        if(winningNumber == null) {
            throw new IllegalArgumentException("[ERROR] " + "당첨 번호가 null이어서는 안 됩니다.");
        }
        if(isDuplicated(value, winningNumber)) {
            throw new IllegalArgumentException("[ERROR] " + "보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private static boolean isDuplicated(int value, WinningNumber winningNumber) {
        List<Integer> winningNumbers = winningNumber.getNumbers();
        for (Integer number : winningNumbers) {
            if(number == value) {
                return true;
            }
        }
        return false;
    }
}
