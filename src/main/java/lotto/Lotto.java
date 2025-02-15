package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Comparator;
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
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
        if (numbers.stream().anyMatch(num -> num <1 || num > 45)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다");
        }
    }

    // TODO: 추가 기능 구현


    public List<Integer> getNumbers() {
        return numbers;
    }


}
