package lotto.model;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;
import java.util.HashSet;


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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }


    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
