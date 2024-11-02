package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public Rank calculateRank(List<Integer> winningLottoNumbers, int bonusNumber) {
        int basicCount = 0;
        int bonusCount = 0;
        for (int winningLottoNumber : winningLottoNumbers) {
            if (numbers.contains(winningLottoNumber)) {
                basicCount++;
            }
        }
        if (numbers.contains(bonusNumber)) {
            bonusCount++;
        }

        return Rank.calculateRank(basicCount, bonusCount);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_MAX_NUMBER.getUnit()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() < LOTTO_MAX_NUMBER.getUnit()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
