package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BonusNumberValidator {
    public List<Integer> validate(String bonusNumber, List<Integer> winningNumbers) {
        isBlank(bonusNumber);

        return convert(bonusNumber, winningNumbers);
    }

    private void isBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 비어있습니다.");
        }
    }

    private void validateNumberRange(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateUniqueNumber(Integer bonusNumber, List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        uniqueNumbers.add(bonusNumber);
        if (uniqueNumbers.size() < winningNumbers.size() + 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private List<Integer> convert(String input, List<Integer> winningNumbers) {
        try {
            Integer bonusNumber = Integer.parseInt(input);
            validateNumberRange(bonusNumber);
            validateUniqueNumber(bonusNumber, winningNumbers);
            winningNumbers.add(bonusNumber);
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수로만 입력이 가능합니다.");
        }
    }
}