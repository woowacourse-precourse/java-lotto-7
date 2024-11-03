package lotto;

import static lotto.LottoRule.NUMBER_LENGTH;
import static lotto.LottoRule.RANGE_HIGH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            String message = String.format("[ERROR] 로또 번호는 %d개여야 합니다.", NUMBER_LENGTH);
            throw new IllegalArgumentException(message);
        }
        boolean[] check = new boolean[RANGE_HIGH + 1];
        for (Integer number : numbers) {
            if (check[number])
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 있으면 안됩니다.");
            check[number] = true;
        }
    }

    public int getPlace(List<Integer> winningNumbers, int bonus) {
        int matchCount = 0;
        boolean isBonusMatch = false;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number))
                matchCount += 1;
            if (bonus == number)
                isBonusMatch = true;
        }

        return LottoRule.getPlace(matchCount, isBonusMatch);
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
