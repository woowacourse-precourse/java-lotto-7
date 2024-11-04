package lotto.service;

import lotto.enums.LottoValue;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoTicket;
import lotto.validator.AmountValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseService {

    private final AmountValidator amountValidator;
    private final LottoMachine lottoMachine;

    public LottoPurchaseService(AmountValidator amountValidator, LottoMachine lottoMachine) {
        this.amountValidator = amountValidator;
        this.lottoMachine = lottoMachine;
    }

    public LottoTicket purchaseLotto(String input) {
        int price = validateAmount(input);
        int ticketCount = calculateQuantity(price);
        List<Lotto> lotteries = generateLotteries(ticketCount);
        return new LottoTicket(lotteries, price, ticketCount);
    }

    private int validateAmount(String input) {
        amountValidator.validate(input);
        return Integer.parseInt(input);
    }

    private int calculateQuantity(int price) {
        return price / LottoValue.PRICE_PER_LOTTO.getValue();
    }

    private List<Lotto> generateLotteries(int quantity) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lotteries.add(lottoMachine.generate());
        }
        return lotteries;
    }
}
