package lotto.model.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.draw.LottoNumbersGenerator;

public class LottoTickets {

    private final List<LottoNumbersGenerator> lottoTickets;

    private LottoTickets(int ticketCount) {
        this.lottoTickets = collectLottoTickets(ticketCount);
    }

    public static LottoTickets createTickets(int ticketCount) {
        return new LottoTickets(ticketCount);
    }

    private List<LottoNumbersGenerator> collectLottoTickets(int ticketCount) {
        return Stream.generate(LottoNumbersGenerator::createAutoLotto)
                .limit(ticketCount)
                .collect(Collectors.toList());
    }

    public List<LottoNumbersGenerator> getLottoTickets() {
        return lottoTickets;
    }
}