package lotto.model.domain;

import static lotto.constant.LottoGameConfig.SPLIT_DELIMITER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private final List<LottoNumber> numbers;

    public WinningNumbers(String stringNumbers) {
        validateInput(stringNumbers);
        validateLottoSize(stringNumbers);
        validateUniqueNumbers(stringNumbers);
        numbers = Arrays.stream(stringNumbers.split(SPLIT_DELIMITER))
                .map(LottoNumber::new)
                .toList();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private void validateLottoSize(String stringNumbers) {
        String[] numbers = stringNumbers.split(SPLIT_DELIMITER);
        if (numbers.length != 6) {
            throw new IllegalArgumentException("숫자를 6개 입력해주세요.");
        }
    }

    private void validateUniqueNumbers(String stringNumbers) {
        String[] numbers = stringNumbers.split(SPLIT_DELIMITER);
        Set<String> set = new HashSet<>(List.of(numbers));
        if (set.size() != numbers.length) {
            throw new IllegalArgumentException("당첨 번호는 중복되면 안 됩니다.");
        }
    }

    private void validateInput(String stringNumbers) {
        if (stringNumbers == null || stringNumbers.isBlank()) {
            throw new IllegalArgumentException("당첨 번호를 입력해 주세요.");
        }
    }
}
