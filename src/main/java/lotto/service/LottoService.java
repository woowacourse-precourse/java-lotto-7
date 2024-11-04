package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBER_CNT = 6;

    private Lotto generateLotto() {
        List<LottoNumber> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER,
                        NUMBER_CNT)
                .stream()
                .map(LottoNumber::new)
                .toList();
        return new Lotto(numbers);
    }
}
