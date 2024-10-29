package lotto;

import java.util.stream.IntStream;
import lotto.domain.LottoTickets;
import lotto.domain.Lotto;
import lotto.generator.Generator;

public class LottoMachine {
    private final Generator generator;

    public LottoMachine(Generator generator) {
        this.generator = generator;
    }

    public LottoTickets getLottoTickets(int purchaseAmount) {
        int quantity = getQuantity(purchaseAmount);
        return generateLottoTickets(quantity);
    }

    private int getQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private LottoTickets generateLottoTickets(int quantity) {
        return LottoTickets.of(IntStream.range(0, quantity)
                .mapToObj(index -> new Lotto(
                        generator.generateNumbers().stream().sorted().toList()
                ))
                .toList());
    }
}
