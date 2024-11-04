package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchCount(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getPrize(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = matchCount(winningNumbers);
        if (matchCount == 6) return 2000000000; // 1등
        if (matchCount == 5 && contains(bonusNumber)) return 30000000; // 2등
        if (matchCount == 5) return 1500000; // 3등
        if (matchCount == 4) return 50000; // 4등
        if (matchCount == 3) return 5000; // 5등
        return 0; // 당첨 없음
    }
    // TODO: 추가 기능 구현
}
