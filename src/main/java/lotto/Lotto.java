package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for(int number: numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR]");
            }
        }
        HashSet<Integer> duplicate = new HashSet<>(numbers);
        if(duplicate.size() != 6){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력 할 수 없습니다");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

}
