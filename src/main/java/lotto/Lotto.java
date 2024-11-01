package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하만 가능합니다.");
            }
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Rank matchWinNumbers(List<Integer> winNumbers, int bonusNumber) {
        int matchCount = 0;

        for (int number : numbers) {
            if (winNumbers.contains(number)) {
                matchCount++;
            }
        }

        boolean matchBonus = numbers.contains(bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }

    public void sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

}
