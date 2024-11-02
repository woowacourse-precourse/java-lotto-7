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
        SequencedSet<Integer> numbers = parser.ParseWinningNumber("1,2,3,4,5,6");
        WinningNumber winNum = new WinningNumber(numbers);
        winNum.addBonusNumber(7);

        NumberGenerator numberGenerator = new NumberGenerator();
        PurchaseMoney purchaseMoney = new PurchaseMoney(100000);
        LottoMachine lottoMachine = new LottoMachine(numberGenerator, purchaseMoney);
        Lottos lottos = lottoMachine.createLottos();
        MatchCalculator matchCalculator = new MatchCalculator(winNum, lottos);
        matchCalculator.calculatePrize();
        Map<Prize, Integer> prizes = matchCalculator.getPrizes();

        prizes.forEach((key, value) -> System.out.printf("키 : %s, 밸류 : %s%n", key, value));

        OutputView outputView = new OutputView();
        outputView.purchaseLottoAmount(5);
        outputView.purchaseLottoNumbers(lottos);
        outputView.earnRate(matchCalculator.calculateEarnRate());
        outputView.winningDetails(prizes);
    }
}
