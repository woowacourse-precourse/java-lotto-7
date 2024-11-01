package lotto.service;

import static lotto.parser.InputParser.parseInteger;

import lotto.model.LottoPurchasePrice;

public class LottoTicketService {

    public LottoPurchasePrice getLottoPurchasePrice(String inputPurchasePrice) {
        return new LottoPurchasePrice(parseInteger(inputPurchasePrice));
    }
}
