package lotto.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers){
        Set<Integer> numSet = new HashSet<>(numbers);

        if(numSet.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 입력되었습니다.");
        }
    }
}
