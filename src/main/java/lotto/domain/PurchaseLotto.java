package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
    private List<Integer> lottoNumbers = new ArrayList<>();

    public PurchaseLotto(){
        createLottoNumbers();
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

    private void createLottoNumbers(){
       lottoNumbers = LottoNumberGenerator.lottoNumbers();
    }
}
