package lotto;

import java.util.*;

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
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다. ");
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        List<Integer> sortNum = new ArrayList<>(this.numbers);
        Collections.sort(sortNum);
        return sortNum;
    }
}
