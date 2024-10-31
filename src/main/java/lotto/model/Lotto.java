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

    public List<Integer> ascNumbers() {
        numbers.sort(Integer::compareTo);
        return numbers;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        numbers.forEach(number -> sb.append(number).append(", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public int confirmWinning(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean confirmBonus(int bonusNumber) {
        return numbers.stream().anyMatch(number -> number == bonusNumber);
    }
}
