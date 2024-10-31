package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.constants.LottoConstInteger;
import lotto.domain.Lotto;

public class LottoService {
    public List<Lotto> makeLottos(int validPurchasePrice) {
        int lottoCount = validPurchasePrice / LottoConstInteger.LOTTO_PRICE.getValue();
        return IntStream.range(0, lottoCount)
                .mapToObj(it -> makeLotto())
                .toList();
    }

    private Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoConstInteger.LOTTO_START_NUMBER.getValue(),
                        LottoConstInteger.LOTTO_END_NUMBER.getValue(),
                        LottoConstInteger.LOTTO_NUMBER_COUNT.getValue())
                .stream()
                .sorted()
                .toList());
    }
}
