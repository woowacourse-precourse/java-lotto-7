package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.config.LottoConfig;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator implements Generator<Money, List<Lotto>> {

    private final RandomNumberGenerator randomNumberGenerator;

    public LottoAutoGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public List<Lotto> generate(Money money) {
        int count = money.amount() / LottoConfig.LOTTO_PRICE;

        return IntStream.range(0, count)
            .mapToObj(i -> new Lotto(randomNumberGenerator.generate(
                LottoConfig.START_NUMBER,
                LottoConfig.END_NUMBER,
                LottoConfig.LOTTO_SIZE)))
            .collect(Collectors.toList());
    }
}
