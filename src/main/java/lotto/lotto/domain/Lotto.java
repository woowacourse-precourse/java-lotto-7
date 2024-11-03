package lotto.lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!LottoValidator.NUMBERS_SIZE.check(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (!LottoValidator.DUPLICATED.check(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        if (!LottoValidator.OUT_OF_RANGE.check(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    /**
     * 로또를 자동으로 발행합니다.
     *
     * @return 랜덤한 번호로 구성된 로또
     */
    public static Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }

    /**
     * 로또를 수동으로 발행합니다.
     *
     * @param numbers 수동으로 발행할 로또 번호
     * @return 입력한 번호로 구성된 로또
     */
    public static Lotto issue(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
