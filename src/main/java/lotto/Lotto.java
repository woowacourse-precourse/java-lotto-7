package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.info.LottoInfo;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoInfo.MIN_NUMBER.getNumber(), LottoInfo.MAX_NUMBER.getNumber(),
                LottoInfo.COUNT.getNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
