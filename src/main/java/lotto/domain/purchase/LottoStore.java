package lotto.domain.purchase;

import java.util.List;
import java.util.stream.IntStream;
import lotto.constant.LottoRule;
import lotto.domain.number.Lotto;
import lotto.domain.generator.LottoGenerator;

public class LottoStore {

    private final LottoGenerator lottoGenerator;

    public LottoStore(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> getLottosByMoney(final Money money) {
        final int count = money.calculateQuotient(LottoRule.MONEY_UNIT);
        return IntStream.range(0, count)
                .mapToObj(number -> lottoGenerator.generate(LottoRule.MIN_NUMBER, LottoRule.MAX_NUMBER,
                        LottoRule.WINNING_NUMBER_SIZE))
                .toList();
    }
}
