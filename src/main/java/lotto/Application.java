package lotto;

import lotto.domain.*;
import lotto.util.NumberGenerator;
import lotto.util.Parser;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.SequencedSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Parser parser = new Parser();
        Lotto numbers = new Lotto(List.of(7, 12, 19, 22, 34, 41));
        WinningNumber winNum = new WinningNumber(numbers);
        winNum.addBonusNumber(30);

        NumberGenerator numberGenerator = new NumberGenerator();
        PurchaseMoney purchaseMoney = new PurchaseMoney(100000);
        LottoMachine lottoMachine = new LottoMachine(numberGenerator, purchaseMoney);
        Lottos lottos = lottoMachine.createLottos();
        MatchCalculator matchCalculator = new MatchCalculator(winNum, lottos);
        matchCalculator.calculatePrize();
        Map<Prize, Integer> prizes = matchCalculator.getPrizes();

        OutputView outputView = new OutputView();
        outputView.purchaseLottoAmount(5);
        outputView.purchaseLottoNumbers(lottos);
        outputView.earnRate(matchCalculator.calculateEarnRate());
        outputView.winningDetails(prizes);
    }
}
