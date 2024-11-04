package lotto.domain.generator;

import static lotto.message.CommonConstants.LOTTO_MAX_NUMBER;
import static lotto.message.CommonConstants.LOTTO_MIN_NUMBER;
import static lotto.message.CommonConstants.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generate() {
        return new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE));
    }

}
