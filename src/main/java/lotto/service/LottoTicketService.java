package lotto.service;

import static lotto.common.LottoRule.LOTTO_PRICE;
import static lotto.parser.InputParser.parseInteger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoPurchasePrice;
import lotto.model.LottoTicketCount;
import lotto.service.generator.TicketNumberGenerator;

public class LottoTicketService {
    private final TicketNumberGenerator ticketNumberGenerator;

    public LottoTicketService(TicketNumberGenerator ticketNumberGenerator) {
        this.ticketNumberGenerator = ticketNumberGenerator;
    }

    public LottoPurchasePrice getLottoPurchasePrice(String inputPurchasePrice) {
        return new LottoPurchasePrice(parseInteger(inputPurchasePrice));
    }

    public LottoTicketCount calculateLottoTicketCount(LottoPurchasePrice lottoPurchasePrice) {
        return new LottoTicketCount(lottoPurchasePrice.price() / LOTTO_PRICE.getValue());
    }

    public List<Lotto> generateLottos(LottoTicketCount lottoTicketCount) {
        return IntStream.range(0, lottoTicketCount.ticketCount())
                .mapToObj(idx -> new Lotto(ticketNumberGenerator.generateTicketNumbers()))
                .collect(Collectors.toList());
    }
}
