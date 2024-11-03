package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int matchCount;
    private boolean containsBonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.matchCount = 0;
        this.containsBonusNumber = false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 중 중복된 번호가 존재합니다.");
        }
    }

    public void updateMatchCount(List<Integer> winningNumber) {
        this.matchCount = (int) numbers.stream().filter(winningNumber::contains).count();
    }

    public void updateContainsBonusNumber(Integer bonusNumber) {
        this.containsBonusNumber = numbers.contains(bonusNumber);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isContainsBonusNumber() {
        return containsBonusNumber;
    }
}
