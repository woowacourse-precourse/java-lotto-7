package lotto.domain;

import lotto.domain.dto.LottoResultDto;

import java.util.List;

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
        for (int i = 0; i < this.numbers.size(); i++) {
            if (winningNumber.getBonusNumber() == this.numbers.get(i)) {
                isBonus = true;
                continue;
            }
            if (winningNumber.getWinningNumbers()[i] == this.numbers.get(i)) {
                matchCount++;
            }
        }
        return new LottoResultDto(matchCount, isBonus);
    }
}
