package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public int LottoNumber(int purchase_amount){
        return purchase_amount/1000;
    }
    private List<Integer> getGenerateLotto(){
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers=Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }
}
