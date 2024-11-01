package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.model.LottoTicket;
import lotto.validator.LottoTicketValidator;

public class LottoTicketGenerator {
	public static final int LOTTO_PRICE = 1000;

    public static List<LottoTicket> generateTickets(int purchasePrice) {
    	LottoTicketValidator.validatePurchasePrice(purchasePrice);
    	
        int ticketCount = purchasePrice / LOTTO_PRICE;
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }
}