package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
    }

    // TODO: 추가 기능 구현
    public static Lotto randomLotto() {
        List<Integer> random = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(random);
        Collections.sort(lotto.numbers);
        return lotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
