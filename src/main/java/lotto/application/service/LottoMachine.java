package lotto.application.service;

import static lotto.common.Consts.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;
import lotto.application.model.Lotto;

public class LottoMachine {

    private final int lottoPrice;

    public LottoMachine(){
        this.lottoPrice = LOTTO_PRICE;
    }

    public Set<Lotto> purchaseLotto(int amount){
        Set<Lotto> lottos = new HashSet<>();

        fillLottoSet(lottos, amount);

        return lottos;
    }

    private void fillLottoSet(Set<Lotto> lottos, int amount){
        for(int i = 0; i < amount / lottoPrice; i++){
            lottos.add(generateLotto());
        }
    }

    private Lotto generateLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

}
