package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.Lotto;


//로또 티켓 생성 및 관리하는 클래스
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