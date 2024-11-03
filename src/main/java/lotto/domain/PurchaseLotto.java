package lotto.domain;

import java.util.List;

public class PurchaseLotto {
    private final List<Integer> lottoNumbers;

    public PurchaseLotto(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

}
