package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoService {

    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public void purchaseLottos(int amout){
        for(int i=0;i<amout/1000;i++){
            purchasedLottos.add(createNewLotto());
        }
    }

    public Lotto createNewLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    public List<Lotto> getPurchasedLottos(){
        return purchasedLottos;
    }


}
