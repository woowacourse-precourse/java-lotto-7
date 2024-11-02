package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

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
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    public static Lotto getLotto() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(integers);
    }
}
