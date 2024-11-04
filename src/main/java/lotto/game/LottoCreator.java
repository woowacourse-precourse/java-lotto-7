package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.OutputHandler;

import java.util.List;

public class LottoCreator {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_MAX_RANGE = 45;
    public static final int LOTTO_MIN_RANGE = 1;
    public Lottos createLottos(int lottoCount) {
        OutputHandler.printLottoCount(lottoCount);
        return getLottos(lottoCount);
    }

    private Lottos getLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < lottoCount; i++) {
            createLottoNumbers(lottos);
        }
        lottos.printLottos();
        return lottos;
    }

    private void createLottoNumbers(Lottos lottos) {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_NUMBER_SIZE);
        Lotto lotto = new Lotto(lottoNumbers);
        lottos.add(lotto);
    }
}
