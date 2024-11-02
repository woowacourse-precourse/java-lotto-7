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
        for(Integer item: numbers) {
            if(!set.add(item)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void search(List<Integer> intList, int bonus) {
        int count = 0;
        for (int i = 0; i < intList.size(); i++) {
            if (numbers.contains(intList.get(i))) {
                count++;
            }
        }

        if (count == LOTTO_BONUS_APPLY && numbers.contains(bonus)) {
            count = LOTTO_BONUS_CORRECT;
        }

        LottoEnum.increaseWinnerCount(count);
    }
}
