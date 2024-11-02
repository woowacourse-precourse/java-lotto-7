package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.ErrorMessages;
import lotto.domain.model.Lotto;


//로또 당첨 등급 및 수익률을 계산하는 클래스
public class LottoPurchaseService {
    private static final int TICKET_PRICE = 1000;

    public List<Lotto> purchaseTickets(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount); // 구입 금액 검증
        int ticketCount = calculateTicketCount(purchaseAmount);
        List<Lotto> tickets = new ArrayList<>();
        LottoGenerationService generationService = new LottoGenerationService();

        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generationService.createLotto());
        }

        return tickets;
    }

    private int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / TICKET_PRICE;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(purchaseAmount == 0 ?
                    ErrorMessages.ZERO_PURCHASE_AMOUNT.getMessage() :
                    ErrorMessages.NEGATIVE_PURCHASE_AMOUNT.getMessage());
        }
        if (purchaseAmount < TICKET_PRICE) {
            throw new IllegalArgumentException(ErrorMessages.MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
