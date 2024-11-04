package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomLottoGenerator implements LottoGenerator{
    // 랜덤으로 로또 생성
    @Override
    public Lotto generate() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        //lottoNumbers.sort(Integer::compareTo);
        return new Lotto(lottoNumbers);
    }

}
