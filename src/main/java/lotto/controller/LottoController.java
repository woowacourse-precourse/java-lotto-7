package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int lottosAmount = InputView.inputPurchase();
        List<Lotto> purchaseLottos = new ArrayList<>();
        for (int i = 0; i < lottosAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchaseLottos.add(new Lotto(numbers));
        }
        OutputView.printLottoTicket(purchaseLottos);

        List<Integer> winNumbers = InputView.WinNumbers();
        int bonusNumber = InputView.BonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(winNumbers), bonusNumber);

        int[] rankCount = new int[LottoRank.ranks.size()];
        for (Lotto lotto : purchaseLottos) {
            int matchCount = 0;
            for (int number : lotto.getNumbers()) {
                if (winningNumbers.getWinningNumber().getNumbers().contains(number)) {
                    matchCount++;
                }
            }
            boolean matchBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
            LottoRank rank = LottoRank.getRank(matchCount, matchBonus);
            rankCount[LottoRank.ranks.indexOf(rank)]++;
        }
    }
}
