package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoList(int count){
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(makeNumbers()));
        }
    }

    private List<Integer> makeNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
