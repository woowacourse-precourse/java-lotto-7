package lotto.service;

public class LottoTicketBuyingService {
    public static Integer buyingLottoTicket(String buyingPrice) {
        return Integer.parseInt(buyingPrice) / 1000;
    }
}
