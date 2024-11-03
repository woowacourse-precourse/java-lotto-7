package lotto.service;

import java.util.List;
import lotto.domain.Calculator;
import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoRaffle;
import lotto.domain.LottoResultChecker;
import lotto.domain.Money;
import lotto.utils.RandomNumberGenerator;

public class GameService {

    public Money createMoney(int purchaseMoney) {
        return new Money(purchaseMoney);
    }

    public LotteryMachine purchaseLotto(Money money) {
        LotteryMachine lotteryMachine = new LotteryMachine(new RandomNumberGenerator(), money);
        lotteryMachine.createLottoByPayment();
        return lotteryMachine;
    }

    public LottoResultChecker lottoResult(List<Integer> winningNumber, int bonusBall, LotteryMachine lotteryMachine) {
        Lotto winningLotto = new Lotto(winningNumber);
        LottoRaffle lottoRaffle = new LottoRaffle(winningLotto, bonusBall);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(lottoRaffle, lotteryMachine.getPurchaseLotto());
        lottoResultChecker.findRank();
        return lottoResultChecker;
    }

    public double calculateProfitRate(LottoResultChecker lottoResultChecker, Money money) {
        Calculator calculator = new Calculator(lottoResultChecker, money);
        return calculator.getProfitRate();
    }
}
