package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.Lotto;

public class LottoPurchaseService {
    private static final int TICKET_PRICE = 1000;

    public List<Lotto> purchaseTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / TICKET_PRICE;
        List<Lotto> tickets = new ArrayList<>();
        LottoGenerationService generationService = new LottoGenerationService();

        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generationService.createLotto());
        }
        return tickets;
    }
}