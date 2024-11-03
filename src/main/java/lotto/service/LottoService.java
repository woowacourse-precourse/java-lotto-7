package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class LottoService {
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;

    public List<Lotto> buyLottos(int buyMoney) {
        int lottoCount = buyMoney / 1000;
        List<Lotto> lottos = new ArrayList<>();
        while (lottoCount-- > 0) {
            lottos.add(new Lotto(makeLandomNumber()));
        }
        return lottos;
    }

    private List<Integer> makeLandomNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, 6);
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
