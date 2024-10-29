package lotto;

import java.util.stream.IntStream;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.generator.Generator;

public class LottoMachine {
    private final Generator generator;

    public LottoMachine(Generator generator) {
        this.generator = generator;
    }

    public Lotteries getLotteries(int purchaseAmount) {
        int quantity = getQuantity(purchaseAmount);
        return generateLotteries(quantity);
    }

    private int getQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private Lotteries generateLotteries(int quantity) {
        return Lotteries.of(IntStream.range(0, quantity)
                .mapToObj(index -> new Lotto(generator.generateNumbers()))
                .toList());
    }
}
