package lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.constants.LottoInteger;
import lotto.domain.Lotto;

public class LottoFactory {
    /**
     * 로또 구입 금액을 받아서 로또를 발행한다.
     * 
     * @param validPurchasePrice 로또를 구매하려는 금액
     * @return 발행된 로또 리스트
     */
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
