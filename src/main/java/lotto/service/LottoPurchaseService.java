package lotto.service;

import lotto.model.LottoMachine;
import lotto.model.LottoTicket;
import lotto.validator.AmountValidator;

public class LottoPurchaseService {

    private final AmountValidator amountValidator;
    private final LottoMachine lottoMachine;

    public LottoPurchaseService(AmountValidator amountValidator, LottoMachine lottoMachine) {
        this.amountValidator = amountValidator;
        this.lottoMachine = lottoMachine;
    }

    public LottoTicket purchaseLotto(String input){
        return LottoTicket.create(input, lottoMachine, amountValidator);
    }
}
