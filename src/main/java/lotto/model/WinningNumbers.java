package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class WinningNumbers {
    private static final String DELIMITER = ",";

    private final List<Integer> winningNumbers;

    private WinningNumbers(String userInputNumbers) {
        validate(userInputNumbers);
        List<Integer> numbers = parseNumbers(userInputNumbers);
        Lotto.validate(numbers);
        this.winningNumbers = numbers;
    }

    private void validate(String userInputNumbers) {
        if (userInputNumbers.startsWith(DELIMITER) || userInputNumbers.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 시작과 끝부분에 구분자가 포함될 수 없습니다.");
        }
        if (userInputNumbers.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 구분자 사이에 공백이 포함될 수 없습니다.");
        }
        if (!userInputNumbers.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 숫자와 쉼표(,) 외의 문자가 포함될 수 없습니다.");
        }
    }

    public static WinningNumbers from(String userInputNumbers) {
        return new WinningNumbers(userInputNumbers);
    }

    private List<Integer> parseNumbers(String userInputNumbers) {
        return Arrays.stream(userInputNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
