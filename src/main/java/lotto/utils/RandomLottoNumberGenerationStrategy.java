package lotto.utils;

import static lotto.Lotto.COUNT;
import static lotto.Lotto.END_NUMBER;
import static lotto.Lotto.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumberGenerationStrategy implements LottoNumberGeneratorStrategy {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
    }
}
