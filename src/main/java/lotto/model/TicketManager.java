package lotto.model;

import lotto.vo.Ticket;

import java.util.List;

public class TicketManager { // TODO: 이름 개선
    private final int ticketAmount; // 금액을 ticketAmount로 변환해 저장? 그럼 천원 검증은 어떻게 해??
    private final List<Ticket> tickets;

    public TicketManager(int ticketAmount, List<Ticket> tickets) {
        this.ticketAmount = ticketAmount;
        this.tickets = tickets;
    }
}
