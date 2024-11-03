package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(String numbersInput, String bonusInput) {
        List<Integer> numbers = parseNumbers(numbersInput);
        validateBonusNumber(bonusInput, numbers);
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = Integer.parseInt(bonusInput);
    }

    private List<Integer> parseNumbers(String numbersInput) {
        String[] tokens = numbersInput.split(",");
        if (tokens.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        try {
            return Arrays.stream(tokens)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private void validateBonusNumber(String bonusInput, List<Integer> numbers) {
        if (!bonusInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        int bonus = Integer.parseInt(bonusInput);
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다");
        }
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
