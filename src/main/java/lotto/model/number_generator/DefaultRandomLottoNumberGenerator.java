package lotto.model.number_generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoNumber;

import java.util.List;

public class DefaultRandomLottoNumberGenerator implements RandomLottoNumberGenerator {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    @Override
    public List<LottoNumber> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_NUMBER_SIZE)
                .stream().sorted()
                .map(LottoNumber::from)
                .toList();
    }
}
