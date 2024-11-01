package lotto.factory;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoConstants;

public class LottoTicketFactory {

    public static List<Lotto> generateLottoTickets(int purchaseAmount) {
        int ticketCount = calculateTicketCount(purchaseAmount);
        return createLottoTickets(ticketCount);
    }

    private static int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.PRICE_PER_TICKET.getValue();
    }

    private static List<Lotto> createLottoTickets(int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new Lotto(LottoNumberGenerator.generateLottoNumbers()));
        }
        return lottoTickets;
    }

}
