package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.LottoRank;

public class MyLottoNum {
    private final List<Lotto> lottoList = new ArrayList<Lotto>();

    public MyLottoNum() {
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void makeMyLotto(Integer times) {
        System.out.println(times + "개를 구매했습니다.");
        for (int i = 0; i < times; i++) {
            List<Integer> uniqueLotto = pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> mutableLotto = new ArrayList<>(uniqueLotto);
            Collections.sort(mutableLotto);
            Lotto t_lotto = new Lotto(mutableLotto);
            lottoList.add(t_lotto);
        }
    }

    public void printMyLottoList() {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }
}