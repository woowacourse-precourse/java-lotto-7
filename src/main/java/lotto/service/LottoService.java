package lotto.service;

import static java.lang.Integer.parseInt;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.generator.NumberGenerator;

public class LottoService {

    public Set<Lotto> generateLottosByPurchaseQuantity(int purchaseQuantity, NumberGenerator generator) {
        return IntStream.range(0, purchaseQuantity)
                        .mapToObj(i -> new Lotto(generator.generateNumber()))
                        .collect(Collectors.toSet());
    }

    public int calculatePurchaseQuantity(String purchaseAmount) {
        return parseInt(purchaseAmount) / 1000;
    }
}
