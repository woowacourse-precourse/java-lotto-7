package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoCommittee;
import lotto.model.LottoMachine;
import lotto.model.Ranking;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);
        OutputView.printPurchasedLottoCountAndNumber(lottos);

        List<Integer> winningNumber = InputView.inputWinningNumber();
        Integer bonusNumber = InputView.inputBonusNumber(winningNumber);
        LottoCommittee committee = new LottoCommittee(winningNumber, bonusNumber);

        HashMap<Ranking, Integer> rankingCountMap = committee.calculateRanking(lottos);
        OutputView.printWinningHistory(rankingCountMap);
        OutputView.printRateOfReturn(purchaseAmount, rankingCountMap);
    }
}
