package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Price;

public class LotteryCashier {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_SIZE = 6;

    public Lottos purchaseBy(Price price) {
        int amount = getAvailableAmount(price);
        return new Lottos(purchaseLottos(amount));
    }

    private int getAvailableAmount(Price price) {
        return price.divide(LOTTO_PRICE);
    }

    private List<Lotto> purchaseLottos(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(ignored -> Randoms.pickUniqueNumbersInRange(MIN_INCLUSIVE, END_INCLUSIVE, NUMBER_SIZE))
                .map(this::convertMutable)
                .peek(Collections::sort)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private <T> List<T> convertMutable(List<T> collection) {
        return new ArrayList<>(collection);
    }
}