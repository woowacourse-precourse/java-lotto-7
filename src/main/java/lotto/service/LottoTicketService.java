package lotto.service;

import static lotto.common.LottoRule.LOTTO_PRICE;
import static lotto.parser.InputParser.parseInteger;

import lotto.model.LottoPurchasePrice;
import lotto.model.LottoTicketCount;

public class LottoTicketService {

    public LottoPurchasePrice getLottoPurchasePrice(String inputPurchasePrice) {
        return new LottoPurchasePrice(parseInteger(inputPurchasePrice));
    }

    public LottoTicketCount calculateLottoTicketCount(LottoPurchasePrice lottoPurchasePrice) {
        return new LottoTicketCount(lottoPurchasePrice.price() / LOTTO_PRICE.getValue());
    }
}
