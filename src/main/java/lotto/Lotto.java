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
        hasDuplicates(numbers);
    }

    private void  hasDuplicates(List<Integer> list) {
        if (list.size() != list.stream().distinct().count()){
            throw  new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(Lotto winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers.getNumbers()::contains).count();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
