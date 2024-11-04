package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.util.NumbersGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos purchase(int purchaseCount, NumbersGenerator numbersGenerator) {
        List<Lotto> purchasedLottos = IntStream.range(0, purchaseCount)
                .mapToObj(lotto -> Lotto.of(
                        numbersGenerator.generateNumbers(LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                                LottoConstants.MAX_LOTTO_NUMBER.getValue(), LottoConstants.LOTTO_COUNT.getValue())))
                .toList();
        return new Lottos(purchasedLottos);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
