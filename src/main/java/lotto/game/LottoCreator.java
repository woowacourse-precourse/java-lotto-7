package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoCreator {
    public Lottos createLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < lottoCount; i++) {
            createLottoNumbers(lottos);
        }
        lottos.printLottos();
        return lottos;
    }

    private void createLottoNumbers(Lottos lottos) {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        lottos.add(lotto);
    }
}
