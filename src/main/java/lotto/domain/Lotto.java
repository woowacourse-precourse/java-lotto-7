package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {

    private static final int MAX_COUNT = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Integer> createNumbers(){
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, MAX_COUNT);
    }
}
