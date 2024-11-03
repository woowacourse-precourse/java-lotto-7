package lotto.generator;

import static lotto.constant.LottoNumberConstant.MAX_NUMBER;
import static lotto.constant.LottoNumberConstant.MIN_NUMBER;
import static lotto.constant.LottoNumberConstant.REQUIRED_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {

    public Lotto generate() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, REQUIRED_COUNT);
        return new Lotto(lottoNumbers);
    }
}
