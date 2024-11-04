package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    public List<Lotto> purchaseLottos(int amount) {
        int count = amount / LottoConstants.LOTTO_PRICE.getValue();
        return generateLottos(count);
    }

    public List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_MIN_NUMBER.getValue(),
                LottoConstants.LOTTO_MAX_NUMBER.getValue(),
                LottoConstants.LOTTO_NUMBER_COUNT.getValue()
        );
        return new Lotto(numbers);
    }
}
