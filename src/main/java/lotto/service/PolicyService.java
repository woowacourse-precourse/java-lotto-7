package lotto.service;

import java.security.cert.PolicyNode;
import java.util.List;
import lotto.policy.LottoNumberPolicy;
import lotto.policy.LottoNumberScalePolicy;
import lotto.policy.LottoPricePolicy;
import lotto.policy.PrizeMoneyPolicy;

public class PolicyService {

    public int getLottoNumberScale(){
        return LottoNumberScalePolicy.LOTTO_NUMBER_SCALE.getNumberScale();
    }

    public int getLottoMaxNumber(){
        return LottoNumberPolicy.MAX_NUMBER.number();
    }

    public int getLottoMinNumber(){
        return LottoNumberPolicy.MIN_NUMBER.number();
    }

    public int getLottoTicketPrice(){
        return LottoPricePolicy.LOTTO_TICKET_PRICE.getLottoTicketPrice();
    }

    public List<PrizeMoneyPolicy> getPrizeMoney(int matchedNumberCount){
        return PrizeMoneyPolicy.getPrizeMoney(matchedNumberCount);
    }
}
