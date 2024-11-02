package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sort();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        isSixCountOfList(numbers);
        isDuplicatedNumber(numbers);
    }

    private void isDuplicatedNumber(List<Integer> numbers){
        if(numbers.size() > new HashSet<>(numbers).size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개는 각각 모두 중복 될 수 없습니다.");
        }
    }

    private void isSixCountOfList(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void sort(){
        Collections.sort(numbers);
    }
}
