package lotto.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class WinningNumbers {
    private static final String SEPARATOR = ",";
    private final Lotto winningLotto;

    public WinningNumbers(String winningNumbers) {
        this.winningLotto = validateIntegerNumbers(winningNumbers);
    }

    private Lotto validateIntegerNumbers(String winningNumbers) {
        try {
            List<Integer> numbers = Arrays.stream(winningNumbers.split(SEPARATOR))
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(new ArrayList<>(numbers));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 정수여야 합니다");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
