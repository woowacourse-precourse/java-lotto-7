package lotto.model;

import static lotto.common.constant.LottoNumber.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.common.constant.LottoNumber.LOTTO_NUMBER_UPPER_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoIssuer implements LottoIssuer {

    @Override
    public Lotto issue() {
        List<LottoNumber> numbers =
                Randoms.pickUniqueNumbersInRange(
                                LOTTO_NUMBER_LOWER_BOUND.number(),
                                LOTTO_NUMBER_UPPER_BOUND.number(),
                                6
                        )
                        .stream()
                        .map(LottoNumber::from)
                        .toList();
        return Lotto.from(numbers);
    }
}
