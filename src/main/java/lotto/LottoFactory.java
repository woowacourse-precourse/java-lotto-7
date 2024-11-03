package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoFactory {
    public Lotto createRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        assert isUnique(randomNumbers);

        return new Lotto(randomNumbers);
    }

    private boolean isUnique(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }
}
