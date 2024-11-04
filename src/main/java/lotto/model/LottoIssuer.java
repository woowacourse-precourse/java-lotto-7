package lotto.model;

import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.LottoTickets;

public class LottoIssuer {

    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoIssuer(final LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public LottoTickets issueLottoTickets(final PurchaseAmount amount) {
        final int countOfLotto = amount.calculateLottoCount();
        List<Lotto> lottoTickets = IntStream.range(0, countOfLotto)
                .mapToObj(count -> new Lotto(lottoNumbersGenerator.generate()))
                .toList();
        return new LottoTickets(lottoTickets);
    }
}
