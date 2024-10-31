package lotto.util;

import java.util.List;
import java.util.stream.IntStream;
import lotto.constants.LottoConstants;
import lotto.model.Lotto;

public class LottoTicketFactory {

    public List<Lotto> createTickets(int purchaseAmount) {
        int ticketCount = calculateTicketCount(purchaseAmount);
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(Lotto.generateRandomNumbers()))
                .toList();
    }

    private int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE;
    }

}
