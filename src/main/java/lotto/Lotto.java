package lotto;

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

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자 6개여야 합니다.");
            }
        }

        int number = numbers.getFirst();

        for (int i = 1; i < numbers.size(); i++) {
            if (number == numbers.get(i)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 숫자 6개여야 합니다.");
            }

            number = numbers.get(i);
        }
    }

    // TODO: 추가 기능 구현
    public void printLotto() {
        System.out.println(numbers.stream().sorted().toList());
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto winningNumbers) {
        int matchCount = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean isBonusMatch(int bonusNumber) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }

}
