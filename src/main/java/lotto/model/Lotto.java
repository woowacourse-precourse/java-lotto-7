package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.config.LottoConfig;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = makeRandomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.SIZE.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_NUMBER.getNumber(),
                LottoConfig.MAX_NUMBER.getNumber(), LottoConfig.SIZE.getNumber());
    }
}
