package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoInput;
import lotto.service.CheckLottoNumber;
import lotto.service.EarningCalculator;
import lotto.service.LottoGenerator;
import lotto.view.InputHandler;

import java.util.List;

public class LottoManager {
    private final InputHandler inputHandler;
    private final LottoGenerator lottoGenerator;
    private final CheckLottoNumber checkLottoNumber;
    private final EarningCalculator earningCalculator;
    private final int MAX_EQUALS_LOTTO_NUMBER = 8;

    public LottoManager(InputHandler inputHandler, LottoGenerator lottoGenerator, CheckLottoNumber checkLottoNumber, EarningCalculator earningCalculator) {
        this.inputHandler = inputHandler;
        this.lottoGenerator = lottoGenerator;
        this.checkLottoNumber = checkLottoNumber;
        this.earningCalculator = earningCalculator;
    }

    public void manageLotto() {
        Integer cash = inputHandler.getCash();
        List<Lotto> lotto = lottoGenerator.generateLotto(cash / LottoConstants.LOTTO_PRICE);
        Lotto lottoResult = inputHandler.getLottoNumber();
        Integer bonus = inputHandler.getBonus();

        List<Integer> winners = checkLottoNumber.checkNumber(lotto, lottoResult, bonus);
        int[] countWinners = checkWinners(winners);
        double profit = earningCalculator.calcualteEarningRate(winners, cash);
    }
    private int[] checkWinners(List<Integer> winners) {
        int[] countWinner = new int[MAX_EQUALS_LOTTO_NUMBER];
        for(Integer winner : winners) {
            countWinner[winner]++;
        }
        return countWinner;
    }
}

