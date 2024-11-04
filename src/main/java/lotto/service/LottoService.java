package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class LottoService {
    public List<Lotto> buyLottos(int buyMoney) {
        int lottoCount = buyMoney / 1000;
        List<Lotto> lottos = new ArrayList<>();
        while (lottoCount-- > 0) {
            lottos.add(new Lotto(makeLandomNumber()));
        }
        return lottos;
    }

    private List<Integer> makeLandomNumber() {
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUM, Constants.LOTTO_MIN_NUM, Constants.LOTTO_SIZE);
    }

    public double getYield(int useMoney, int winningMoney) {
        return ((double) winningMoney / (double) useMoney) * 100;
    }

    public LottoResult matchLotto(List<Lotto> lottos, Lotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            lottoResult.countMatchingNumbers(lotto, winningLotto);
        }
        return lottoResult;
    }
}
