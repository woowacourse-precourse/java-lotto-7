package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    //private int prizeTier = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> set = Set.copyOf(numbers);
        if(set.size()<numbers.size()){
            throw new IllegalArgumentException();
        }
    }

     //TODO: 추가 기능 구현
    List<Integer> getNumbers(){
        return numbers;
    }
}
