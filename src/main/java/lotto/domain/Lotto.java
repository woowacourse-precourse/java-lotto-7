package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.LottoRank;

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

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.");
        }
    }


    public LottoRank checkWinningStatus(List<Integer> winningNumbers, int bonusNumber) {

        int matchCount = (int) winningNumbers.stream().filter(numbers::contains).count();

        if (matchCount < 3) {
            return null;
        }

        if (matchCount != 5) {
            return LottoRank.findByMatchCount(matchCount);
        }

        if (numbers.contains(bonusNumber)) {
            return LottoRank.SECOND;
        }

        return LottoRank.THIRD;
    }
}
