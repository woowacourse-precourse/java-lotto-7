package lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.constants.LottoInteger;
import lotto.domain.Lotto;

public class LottoFactory {
    public List<Lotto> makeLottoes(int validPurchasePrice) {
        int lottoCount = validPurchasePrice / LottoInteger.LOTTO_PRICE.getValue();
        return IntStream.range(0, lottoCount)
                .mapToObj(it -> makeLotto())
                .toList();
    }

    private Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoInteger.LOTTO_START_NUMBER.getValue(),
                        LottoInteger.LOTTO_END_NUMBER.getValue(),
                        LottoInteger.LOTTO_NUMBER_COUNT.getValue())
                .stream()
                .sorted()
                .toList());
    }
}
