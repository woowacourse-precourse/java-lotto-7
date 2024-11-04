package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoInput;
import lotto.service.CheckLottoNumber;
import lotto.service.EarningCalculator;
import lotto.service.LottoGenerator;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

import java.util.List;

public class LottoManager {
    private final InputHandler inputHandler;
    private final LottoGenerator lottoGenerator;
    private final CheckLottoNumber checkLottoNumber;
    private final EarningCalculator earningCalculator;
    private final OutputHandler outputHandler;

    private final int MAX_EQUALS_LOTTO_NUMBER = 8;

    public LottoManager(InputHandler inputHandler, LottoGenerator lottoGenerator, CheckLottoNumber checkLottoNumber, EarningCalculator earningCalculator, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.lottoGenerator = lottoGenerator;
        this.checkLottoNumber = checkLottoNumber;
        this.earningCalculator = earningCalculator;
        this.outputHandler = outputHandler;
    }

    public void manageLotto() {
        Integer cash = inputHandler.getCash();
        List<Lotto> lotto = lottoGenerator.generateLotto(cash / LottoConstants.LOTTO_PRICE);
        outputHandler.displayLotto(lotto, cash / LottoConstants.LOTTO_PRICE);

        Lotto lottoResult = inputHandler.getLottoNumber();
        Integer bonus = inputHandler.getBonus(lottoResult);

        List<Integer> winners = checkLottoNumber.checkNumber(lotto, lottoResult, bonus);
        int[] countWinners = checkWinners(winners);
        outputHandler.displayWinning(countWinners);

        double profit = earningCalculator.calcualteEarningRate(winners, cash);
        outputHandler.displayProfit(profit);
    }
    private int[] checkWinners(List<Integer> winners) {
        int[] countWinner = new int[MAX_EQUALS_LOTTO_NUMBER];
        for(Integer winner : winners) {
            countWinner[winner]++;
        }
        return countWinner;
    }
}

