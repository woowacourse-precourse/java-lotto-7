package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoModel {
    private List<Integer> lottoNumbers = new ArrayList<>(); //이거 안될 수도 있음 여러개 발행해야함
    private List<List<Integer>> lotto = new ArrayList<>();

    public List<Integer> getLottoNumbers(int i) {
        lotto.add(makeRandomLottoNumbers());
        return lotto.get(i);
    }

    public List<List<Integer>> getLotto() {
        return lotto;
    }

    public List<Integer> makeRandomLottoNumbers() {
        //랜덤이 중복으로 안 나옴
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(list);
        return list;
    }
}
