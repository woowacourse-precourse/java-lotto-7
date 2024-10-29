package lotto;

import static lotto.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoConstants.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachineImpl implements LottoMachine {
    @Override
    public Lotto generateLotto() {
        List<Integer> lottoNumbers =
                Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);

        return new Lotto(lottoNumbers);
    }

}
