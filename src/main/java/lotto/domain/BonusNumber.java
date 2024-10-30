package lotto.domain;

import java.util.List;

public class BonusNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int number;

    public BonusNumber(String input, List<Integer> winningNumbers) {
        this.number = parseAndValidate(input, winningNumbers);
    }

    private int parseAndValidate(String input, List<Integer> winningNumbers) {
        try {
            int number = Integer.parseInt(input);
            if (number < MIN || number > MAX) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
            }
            if (winningNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
