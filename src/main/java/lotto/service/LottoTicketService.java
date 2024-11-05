package lotto.service;

import lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketService {
    public List<LottoTicket> createLottoTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }
}