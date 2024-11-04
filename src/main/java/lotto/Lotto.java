package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (isDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 될 수 없습니다.");
        }
    }

    private List<Integer> getNumbers(){
        return numbers;
    }

    public static boolean isDuplicate(List<Integer> numbers){
        Set<Integer> hashSet = new HashSet<>(numbers);
        return hashSet.size() != numbers.size();
    }



    // TODO: 추가 기능 구현
}
