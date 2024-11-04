package lotto;

import enums.Prize;
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

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 각각의 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getNumberOfMatch(List<Integer> ticket) {
        int count = 0;
        for (int number : ticket) {
            if (this.numbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public Prize getLottoRank(List<Integer> ticket, boolean hasBonusNumber) {
        int numberofMatch = getNumberOfMatch(ticket);

        if (numberofMatch == 6) {
            return Prize.FIRST;
        }

        if (numberofMatch == 5 && hasBonusNumber) {
            return Prize.SECOND;
        }

        if (numberofMatch == 5) {
            return Prize.THIRD;
        }

        if (numberofMatch == 4) {
            return Prize.FOURTH;
        }

        if (numberofMatch == 3) {
            return Prize.FIFTH;
        }

        return null;
    }
}
