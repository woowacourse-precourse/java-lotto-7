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
        for (int i = 0; i < numbers.size(); i++) {  // 추가됨
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
                }
            }
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString(); // 숫자 리스트를 문자열로 반환
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto winningLotto) {
        int count = 0;
        for (int number : numbers) {
            if (winningLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
