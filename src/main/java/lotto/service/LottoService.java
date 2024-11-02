package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    final int LOTTO_PRICE = 1000;

    public List<Lotto> purchaseLotto(int purchaseAmount){
        if(purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위이어야 합니다.");
        }
        int purchaseLottoCount = purchaseAmount / LOTTO_PRICE;
        return issueLotto(purchaseLottoCount);
    }

    private List<Lotto> issueLotto(int purchaseLottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<purchaseLottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

}
