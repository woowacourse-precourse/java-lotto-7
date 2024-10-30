package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicates(numbers);
        validateSize(numbers);
        validateRange(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateRange(List<Integer> numbers) {
        for (int number: numbers){
            if(number<1||number>45){
                throw new IllegalArgumentException("[ERROR]로또 번호의 범위를 벗어납니다.");
            }
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(numbers.size()!= uniqueNumbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
