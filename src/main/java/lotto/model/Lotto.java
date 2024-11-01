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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size()!=numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 존재하지 않아야합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public int countMatchingNumbers(List<Integer> winNumbers) {
        int total = 0;
        for (Integer winNumber : winNumbers) {
            if (isContains(winNumber)) {
                total++;
            }
        }
        return total;
    }

    public boolean isContains(Integer number) {
        return numbers.contains(number);
    }
}
