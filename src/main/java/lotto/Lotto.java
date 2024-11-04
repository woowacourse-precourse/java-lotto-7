package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(Lotto otherLotto) {
        List<Integer> curwinningLotto = this.numbers;
        List<Integer> tempLotto = otherLotto.getNumbers();
        int match = 0;

        for (Integer number : curwinningLotto) {
            if (tempLotto.contains(number)) {
                match++;
            }
        }

        return match; // 일치하는 번호 개수 반환
    }
}
