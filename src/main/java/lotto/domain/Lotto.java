package lotto.domain;

import static lotto.Util.Validator.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Util.Validator;
import lotto.message.ExceptionMessage;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public static Lottos buyAsMoney(int money) {
        List<Lotto> boughtLottos = new ArrayList<>();
        validateThousandUnitAmount(money);
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            boughtLottos.add(createLotto());
        }
        return new Lottos(boughtLottos);
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        int matchingNumberCount = 0;
        for (Integer number : numbers) {
            if (winningLotto.isContain(number)) {
                matchingNumberCount++;
            }
        }
        return matchingNumberCount;
    }

    public boolean isContain(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        validateExactlySixNumber(numbers);
    }
}
