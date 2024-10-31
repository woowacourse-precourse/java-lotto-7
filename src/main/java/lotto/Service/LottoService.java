package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
public class LottoService {
    private static final int MAX_MARCH=6;
    private static final int START_LOTTO_NUMBER=1;
    private static final int END_LOTTO_NUMBER=45;
    private static final int LOTTO_COUNT=6;

    public List<Lotto> purchaseLotto(int purchase_amount){
        List<Lotto> lottos = new ArrayList<>();
        int lotto_count=LottoNumber(purchase_amount);
        for(int i=0;i<lotto_count;i++){
            lottos.add(getGenerateLotto());
        }
        return lottos;
    }
    public int LottoNumber(int purchase_amount){
        return purchase_amount/1000;
    }
    private Lotto getGenerateLotto(){
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers=Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_COUNT);
        return new Lotto(lottoNumbers);
    }


}
