package lotto.service;

import lotto.policy.LottoNumberPolicy;
import lotto.policy.LottoNumberScalePolicy;

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
}
