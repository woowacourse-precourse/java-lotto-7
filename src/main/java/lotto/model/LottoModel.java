package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoModel {
//    private List<Integer> lottoNumbers = new ArrayList<>(); //이거 안될 수도 있음 여러개 발행해야함
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto lotto;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getLottoNumbers(int i) {
//        lottos.add(makeRandomLottoNumbers());
        return lottos.get(i).getNumbers();
    }

    public Lotto makeRandomLottoNumbers() {
        //랜덤이 중복으로 안 나옴
//        List<Integer> list = Lotto(new ArrayList<>());
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(list);
        lotto = new Lotto(list);
        lottos.add(lotto);
        return lotto;
    }
}
