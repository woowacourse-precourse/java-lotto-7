package lotto.model;

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
    }

    public static int countMatchingNumbers(Lotto ticket, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer number : ticket.numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }


    @Override
    public String toString() {
        return numbers.toString();  // 번호 리스트를 문자열로 반환
    }

}
