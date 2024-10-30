package lotto.lottery.infrastructure;

import static lotto.global.util.LottoConst.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.global.util.LottoConst;
import lotto.lottery.service.port.RandomHolder;

public class LottoRandomHolder implements RandomHolder {

    @Override
    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS);
    }

}
