package lotto.service;

public class TicketsService {

    private static final int TICKET_COST = 1000;

    public static int purchaseTickets(int amount) {
        int purchaseTickets = amount / TICKET_COST;
        return purchaseTickets;
    }

}
