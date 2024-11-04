package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private List<Lotto> lottoList = new ArrayList<>();

    public List<Lotto> createLotto(int count) {
        for (int i=0; i<count; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(lottoNumbers));
        }
        return lottoList;
    }
}
