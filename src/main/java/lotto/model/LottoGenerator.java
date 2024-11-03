package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Constant.LottoRule.*;

public class LottoGenerator {

    public List<Lotto> generateLottoByFactory (int lottoCount) {
        List<Lotto> lottos = new ArrayList<>(lottoCount);
        for(int i=0; i<lottoCount; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public Lotto generateLottoByUser(List<Integer> lottoNumber, int bonusBall) {
        Lotto lotto = new Lotto(lottoNumber);
        lotto.validateBonusBall(bonusBall);
        return lotto;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumber = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_COUNT);
        return new Lotto(lottoNumber);
    }

}
