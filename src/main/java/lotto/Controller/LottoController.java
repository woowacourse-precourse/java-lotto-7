package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.LottoMachine;
import lotto.Model.LottoResult;
import lotto.Model.Rank;
import lotto.View.Input;
import lotto.View.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoController {
    public void run() {
        int purchaseAmount = Input.inputPurchaseAmount();
        List<Lotto> lottos = LottoMachine.generateLottos(purchaseAmount);
        Output.printLottos(lottos);

        Set<Integer> winningNumbers = Input.inputWinningNumbers();  // 수정된 부분
        int bonusNumber = Input.inputBonusNumber(winningNumbers);   // 수정된 부분

        List<Rank> ranks = calculateRanks(lottos, winningNumbers, bonusNumber);
        LottoResult lottoResult = new LottoResult(ranks);
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);

        Output.printResult(ranks, profitRate);
    }

    private List<Rank> calculateRanks(List<Lotto> lottos, Set<Integer> winningNumbers, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            long matchCount = lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            ranks.add(Rank.getRank((int) matchCount, bonusMatch));
        }
        return ranks;
    }
}
