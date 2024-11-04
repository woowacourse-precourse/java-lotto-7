package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoDTO;
import lotto.model.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoController {
    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = generateLottos(numberOfLottos);

        OutputView.printPurchasedLottos(lottos);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);

        OutputView.printStatistics(lottos, winningNumbers, bonusNumber);
    }

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}