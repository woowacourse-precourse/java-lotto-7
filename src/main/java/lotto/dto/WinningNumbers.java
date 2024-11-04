package lotto.dto;

import java.util.Arrays;
import lotto.domain.Lotto;

public class WinningNumbers {
    private static final String SEPARATOR = ",";
    private final Lotto winningNumbers;

    public WinningNumbers(String winningNumbers) {
        this.winningNumbers = validateIntegerNumbers(winningNumbers);
    }

    private Lotto validateIntegerNumbers(String winningNumbers) {
        try {
            return new Lotto(Arrays.stream(winningNumbers.split(SEPARATOR))
                    .map(Integer::parseInt)
                    .toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 정수여야 합니다");
        }
    }
}
