package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateDuplication(numbers);
        validate(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers){
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자를 입력해야 합니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for(Integer number : numbers){
            if(number < 1 || number > 46){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자를 입력해야 합니다.");
            }
        }
    }
}
