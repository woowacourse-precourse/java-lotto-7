package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;

    public List<Lotto> buyLottos(int lottoCount) {
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
        return Math.round(useMoney / winningMoney * 10) / 10.0;
    }
}
