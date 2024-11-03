package lotto.domain;

public class LottoTicketCalculator {

    private static final int Lotto_Ticket_Divider = 1000;

    public int getLottoTicketsCount(String money) {
        return Integer.parseInt(money) / Lotto_Ticket_Divider;
    }
}
