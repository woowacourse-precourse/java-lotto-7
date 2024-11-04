package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int matchCount;
    private boolean correctBonus;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
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

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean getCorrectBonus() {
        return this.correctBonus;
    }

    public void setCorrectBonusTrue() {
        this.correctBonus = true;
    }
}
