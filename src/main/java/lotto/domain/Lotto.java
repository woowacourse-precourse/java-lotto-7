package lotto.domain;

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
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int matchCount(List<Integer> winNumber, int bonusNumber) {
        int matchCount = 0;
        for (int number : numbers) {
            if(winNumber.contains(number)){
                matchCount++;
            }
        }

        if (numbers.contains(bonusNumber)) {
            matchCount++;
        }

        return matchCount;
    }

    public boolean bonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
