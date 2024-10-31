package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplacate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validateDuplacate(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 모두 달라야 합니다.");
        }
    }

    public void validateRange(List<Integer> numbers){
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(this.numbers);
        Collections.sort(sortedNumbers);
        return numbers.toString();
    }

    public int countMatches(Lotto goals) {
        int count = 0;
        for (int number : numbers) {
            if (goals.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public Rank getRank(Lotto goals, int bonusNumber) {
        int count = countMatches(goals);
        boolean bonusMatch = numbers.contains(bonusNumber);
        return Rank.valueOf(count, bonusMatch);
    }

}
