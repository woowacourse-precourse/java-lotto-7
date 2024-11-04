package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    public List<Lotto> getLottos(int amount){
        List<Lotto> lottos = new ArrayList<>();
        int lottoQuantity = purchaseLotto(amount);
        for (int i = 0; i<lottoQuantity; i++){
            lottos.add(new Lotto(LottoNumbers()));
        }
        return lottos;
    }

    private int purchaseLotto(int amount){
        return amount/1000;
    }

    private List<Integer> LottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
