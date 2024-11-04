package lotto.machine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {
    public Lotto generateByRandom(int minLottoNumber, int maxLottoNumber, int lottoNumberCount) {
        final List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(minLottoNumber, maxLottoNumber, lottoNumberCount));
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
