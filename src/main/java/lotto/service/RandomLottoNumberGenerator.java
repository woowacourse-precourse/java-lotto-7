package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .toList();
    }
}
