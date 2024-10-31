package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.WinningNumbers;

import java.util.List;

public class LottoGame {
    private final Lottos lottos = new Lottos();

    public int createRandomLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.addLotto(lotto);
        }

        lottos.printLottos();

        return lottos.getSize();
    }

    public void start(WinningNumbers winningNumbers) {
        LottoPrizeRecord lottoPrizeRecord = lottos.checkLottos(winningNumbers);
        lottoPrizeRecord.printResult();
    }
}
