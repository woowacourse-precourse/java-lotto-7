package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGamePlayer;
import lotto.domain.WinningLotto;

public class LottoGameService {
    private final LottoGamePlayer player;
    private WinningLotto winningLotto;

    public LottoGameService(LottoGamePlayer player) {
        this.player = player;
    }

    public List<Lotto> generatePurchaserLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> randomLottoNumbers = generateRandomLottoNumbers();
            Lotto lotto = new Lotto(randomLottoNumbers);
            lottos.add(lotto);
        }
        player.purchaseLottos(lottos);
        return lottos;
    }

    private List<Integer> generateRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortNumbersAscending(randomNumbers);
        return randomNumbers;
    }

    private void sortNumbersAscending(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
    }

    public void generateWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }
}
