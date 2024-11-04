package lotto.week3.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 null일 수 없습니다.");
        }
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 비어 있을 수 없습니다.");
        }
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (!areNumbersInRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    private Boolean hasDuplicates(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }

    private boolean areNumbersInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= MIN_NUMBER && num <= MAX_NUMBER);
    }





    // TODO: 추가 기능 구현
    public int matchCount(List<Integer> winningNumber){
        return (int) numbers.stream().filter(winningNumber::contains).count();
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
