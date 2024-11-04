package lotto.domain;

import lotto.domain.dto.LottoResultDto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoResultDto countNumberOfWinnings(WinningNumber winningNumber) {
        int matchCount = 0;
        boolean isBonus = false;

        Set<Integer> winningSet = new HashSet<>();
        for (int winning : winningNumber.getWinningNumbers()) {
            winningSet.add(winning);
        }

        for (Integer number : this.numbers) {
            if (winningNumber.getBonusNumber() == number) {
                isBonus = true;
                continue;
            }
            if (winningSet.contains(number)) {
                matchCount++;
            }
        }
        return new LottoResultDto(matchCount, isBonus);
    }
}
