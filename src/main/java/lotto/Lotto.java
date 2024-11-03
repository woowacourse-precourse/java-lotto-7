package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer item : numbers) {
            if (!set.add(item)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void search(List<Integer> winNumbers, int bonus) {
        int matchCount = 0;
        for (Integer winNumber : winNumbers) {
            if (numbers.contains(winNumber)) {
                matchCount++;
            }
        }

        if (matchCount == LOTTO_FIVE_HIT && numbers.contains(bonus)) {
            matchCount = LOTTO_BONUS_HIT;
        }

        LottoEnum.increaseWinnerCount(matchCount);
    }
}
