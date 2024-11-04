package lotto;

import java.util.List;
import java.util.Objects;

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

    // TODO: 추가 기능 구현

    public void addNumberForStringBuilder(StringBuilder stringBuilder) {
        for (Integer number : numbers) {
            stringBuilder.append(number);
            stringBuilder.append(", ");
        }
    }

    public int calculateMatchCount(List<Integer> winNumber) {
        int matchCount = 0;
        for (Integer number : winNumber) {
            for (Integer lotto : numbers) {
                if (Objects.equals(lotto, number)) {
                    matchCount++;
                    break;
                }
            }
        }

        return matchCount;
    }
    public boolean findMatchBonusNumber(int bonusNumber) {
        for(Integer number : numbers) {
            if (bonusNumber == number) return true;
        }
        return false;
    }

}
