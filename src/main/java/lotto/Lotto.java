package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Collections.sort(numbers);
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

    public int getRank(Lotto goals, int bonusNumber){
        int count = countMatches(goals);

        if(count==6){
            return 1;
        }
        else if(count==5){
            if(numbers.contains(bonusNumber)){
                return 2;
            }
            return 3;
        }
        else if(count==4){
            return 4;
        }
        else if(count==3){
            return 5;
        }
        return 0;
    }
}
