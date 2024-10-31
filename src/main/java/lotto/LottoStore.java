package lotto;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoStore {

    private final LottoGenerator lottoGenerator;

    public LottoStore(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> getLottosByMoney(final Money money) {
        final int count = money.calculateQuotient(1_000);
        return IntStream.range(0, count)
                .mapToObj(number -> lottoGenerator.generate(1, 45, 6))
                .toList();
    }
}
