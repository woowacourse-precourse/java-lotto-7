package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.common.Price;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class LotteryCashier {

    public Lottos purchaseBy(Price price) {
        int amount = getAvailableAmount(price);
        return new Lottos(purchaseLottos(amount));
    }

    private int getAvailableAmount(Price price) {
        return price.divide(LottoValue.PRICE);
    }

    private List<Lotto> purchaseLottos(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(ignored -> generateUniqueNumbers())
                .map(this::convertMutable)
                .peek(Collections::sort)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoValue.MIN_NUMBER,
                LottoValue.MAX_NUMBER,
                LottoValue.NUMBER_SIZE
        );
    }

    private <T> List<T> convertMutable(List<T> collection) {
        return new ArrayList<>(collection);
    }
}