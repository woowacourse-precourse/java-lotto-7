package lotto.calculation;

public class LottoTicketManager {
    public static final int LOTTO_TICKET_PRICE = 1000;

    public int calculateTicketCount(int amount) {
        return amount / LOTTO_TICKET_PRICE;
    }
}
