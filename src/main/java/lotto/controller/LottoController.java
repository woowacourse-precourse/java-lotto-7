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
        List<Lotto> purchaseLottos = generateLotto(lottosAmount);
        OutputView.printLottoTicket(purchaseLottos);

        List<Integer> winNumbers = InputView.WinNumbers();
        int bonusNumber = InputView.BonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(winNumbers), bonusNumber);

        int[] rankCount = calculateRankCounts(purchaseLottos, winningNumbers);

        int totalPrize = 0;
        for (int i = 0; i < rankCount.length; i++) {
            totalPrize += rankCount[i] * LottoRank.ranks.get(i).getPrize();
        }
        double earningRate = ((double) totalPrize / (lottosAmount * 1000)) * 100;

        OutputView.printWinningStatistics(rankCount, earningRate);
    }

    public List<Lotto> generateLotto(int lottosAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottosAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public int[] calculateRankCounts(List<Lotto> purchaseLottos, WinningNumbers winningNumbers) {
        int[] rankCounts = new int[LottoRank.ranks.size()];
        for (Lotto lotto : purchaseLottos) {
            LottoRank rank = getRanks(lotto, winningNumbers);
            rankCounts[LottoRank.ranks.indexOf(rank)]++;
        }
        return rankCounts;
    }

    public LottoRank getRanks(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.getWinningNumber().getNumbers().contains(number)) {
                matchCount++;
            }
        }
        boolean matchBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
        return LottoRank.getRank(matchCount, matchBonus);
    }
}
