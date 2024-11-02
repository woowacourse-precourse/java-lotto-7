package lotto.service;

import lotto.domain.LottoPrice;
import lotto.view.ClientInput;

public class LottoService {
    public int purchaseTicket() {
        ClientInput clientInput = new ClientInput();
        LottoPrice lottoPrice = new LottoPrice(clientInput.enterPurchaseAmount());
        return lottoPrice.getTicketQuantity();
    }
}
