package lotto;

import lotto.domain.*;
import lotto.util.NumberGenerator;
import lotto.util.Parser;

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
        PurchaseMoney purchaseMoney = new PurchaseMoney(100000000);
        LottoMachine lottoMachine = new LottoMachine(numberGenerator, purchaseMoney);
        List<Lotto> lotto = lottoMachine.createLotto();
        MatchCalculator matchCalculator = new MatchCalculator(winNum, lotto);
        matchCalculator.calculatePrize();
        Map<Prize, Integer> prizes = matchCalculator.getPrizes();

        prizes.forEach((key, value) -> System.out.printf("키 : %s, 밸류 : %s%n", key, value));
    }
}
