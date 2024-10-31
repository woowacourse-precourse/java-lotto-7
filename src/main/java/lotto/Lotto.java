package lotto;

import java.util.Collections;
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

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }

    public int countMatches(List<Integer> goalNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (goalNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public int getRank(List<Integer> goalNumbers, int bonusNumber){
        int count = countMatches(goalNumbers);

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
