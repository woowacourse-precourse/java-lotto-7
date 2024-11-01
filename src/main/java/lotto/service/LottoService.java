package lotto.service;

import lotto.util.Parser;
import lotto.util.TicketMaker;

public class LottoService {

    public int changeToTicket(String priceInput) {
        int price = Parser.parseToInt(priceInput);

        return TicketMaker.make(price);
    }
}
