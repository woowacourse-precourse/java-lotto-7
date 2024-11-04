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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {
    public void run() {
        int purchaseAmount = Input.inputPurchaseAmount();
        List<Lotto> lottos = LottoMachine.generateLottos(purchaseAmount);
        Output.printLottos(lottos);

        Set<Integer> winningNumbers = Stream.of(Input.inputWinningNumbers().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        int bonusNumber = Input.inputBonusNumber();

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
