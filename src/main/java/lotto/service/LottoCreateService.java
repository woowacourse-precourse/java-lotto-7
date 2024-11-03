package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.vo.Lotto;

import java.util.ArrayList;

public class LottoCreateService {

    public ArrayList<Lotto> getLotto(int count){
        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        return lottos;
    }





}
