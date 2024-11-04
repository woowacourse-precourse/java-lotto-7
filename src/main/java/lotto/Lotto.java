package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateRedundancy(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers){
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i) < 1 || numbers.get(i) > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이로 입력해야 합니다.");
            }
        }
    }

    private void validateRedundancy(List<Integer> numbers){
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if(numbersSet.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 값을 입력할 수 없습니다.");
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
