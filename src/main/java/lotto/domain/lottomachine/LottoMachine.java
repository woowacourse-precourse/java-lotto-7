package lotto.domain.lottomachine;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int ZERO_QUANTITY = 0;

    public PurchasedLottos issueTickets(NumberGenerator numberGenerator, int quantity) {
        List<Lotto> purchasedLottos = IntStream.range(ZERO_QUANTITY, quantity)
                .mapToObj(i -> new Lotto(numberGenerator.generateNumbers()))
                .toList();
        return PurchasedLottos.from(purchasedLottos);
    }
}
