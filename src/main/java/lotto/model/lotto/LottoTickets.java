package lotto.model.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.draw.LottoNumbersGenerator;

public class LottoTickets {

    private final List<LottoNumbersGenerator> lottoTickets;

    //자동
    private LottoTickets(int ticketCount) {
        this.lottoTickets = collectLottoTickets(ticketCount);
    }
    //수동
    private LottoTickets(List<LottoNumbersGenerator> lottoNumbersList) {
        this.lottoTickets = lottoNumbersList;
    }

    public static LottoTickets createTickets(int ticketCount) {
        return new LottoTickets(ticketCount);
    } //자동

    public static LottoTickets createTickets(List<LottoNumbersGenerator> lottoNumbersList) {
        return new LottoTickets(lottoNumbersList);
    } //수동

    private List<LottoNumbersGenerator> collectLottoTickets(int ticketCount) {
        return Stream.generate(LottoNumbersGenerator::createAutoLotto)
                .limit(ticketCount)
                .collect(Collectors.toList());
    }

    public List<LottoNumbersGenerator> getLottoTickets() {
        return lottoTickets;
    }
}