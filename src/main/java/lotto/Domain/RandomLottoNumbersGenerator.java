package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumbersGenerator {
    private static Integer FIRST_LOTTO_NUMBER = 1;
    private static Integer LAST_LOTTO_NUMBER = 45;
    private static Integer COUNT_OF_LOTTO_NUMBER = 6;

    public List<Integer> createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(FIRST_LOTTO_NUMBER, LAST_LOTTO_NUMBER,
                COUNT_OF_LOTTO_NUMBER);
        return numbers;
    }
}

