package lotto.entity;

import static lotto.configuration.LottoConfiguration.LOTTO_MAX_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_MIN_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public static Lotto createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getValue(),
                LOTTO_MAX_NUMBER.getValue(),
                LOTTO_NUMBER_COUNT.getValue());
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

}
