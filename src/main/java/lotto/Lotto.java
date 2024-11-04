package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
        if (numbers.stream().collect(Collectors.toSet()).size() < 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현

    public int getLottoRank(List<Integer> winningLotto, Integer bonusNumber) {
        int countMatchingNumber = 0;
        boolean hasBonusNumber = false;
        for (Integer number : numbers) {
            if (winningLotto.contains(number)) {
                countMatchingNumber++;
            }
        }
        if (numbers.contains(bonusNumber)) {
            hasBonusNumber = true;
        }
        if (countMatchingNumber < 3) {
            return LottoRank.NONE.getRank();
        }
        return getRank(countMatchingNumber, hasBonusNumber);
    }

    public int getRank(int countMatchingNumber, boolean hasBonusNumber) {
        if (countMatchingNumber == 6) {
            return LottoRank.FIRST.getRank();
        }
        if (countMatchingNumber == 5 && hasBonusNumber) {
            return LottoRank.SECOND.getRank();
        }
        if (countMatchingNumber == 5) {
            return LottoRank.THIRD.getRank();
        }
        if (countMatchingNumber == 4) {
            return LottoRank.FOURTH.getRank();
        }
        if (countMatchingNumber == 3) {
            return LottoRank.FIFTH.getRank();
        }
        return LottoRank.NONE.getRank();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
