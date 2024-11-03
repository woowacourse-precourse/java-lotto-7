package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.settings.LottoSettings;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoSettings.MIN_NUMBER.value(), LottoSettings.MAX_NUMBER.value(),
                LottoSettings.SIZE.value());
    }
}
