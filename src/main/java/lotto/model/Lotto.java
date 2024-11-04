package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import lotto.util.ErrorMessages;

public class Lotto {

    public static final Integer LOTTO_PRICE = 1000;

    public static final Integer NUMBER_MIN = 1;
    public static final Integer NUMBER_MAX = 45;
    public static final Integer NUMBER_CNT = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = genRandomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> genRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_MIN, NUMBER_MAX, NUMBER_CNT)
                .stream()
                .sorted()
                .toList();
    }
}
