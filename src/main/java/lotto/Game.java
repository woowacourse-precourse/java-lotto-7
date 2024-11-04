package lotto;

import java.util.List;
import lotto.io.input.Input;
import lotto.io.output.Output;
import lotto.lotto.Lotto;
import lotto.lotto.LottoResult;
import lotto.lotto.LottoService;
import lotto.lotto.LottoWinning;
import lotto.random.RandomImpl;
import lotto.returnrate.ReturnRate;
import lotto.winner.Winner;
import lotto.winner.WinnerService;

public class Game {

    private final LottoService lottoService;

    public Game() {
        this.lottoService = new LottoService(new RandomImpl());
    }

    public void run() {
        int priceInput = getPurchaseAmount();
        List<Lotto> lottos = lottoService.purchaseLottoWithAmount(priceInput);

        displayPurchasedLottos(lottos);

        Winner winner = getWinner();
        WinnerService winnerService = new WinnerService(winner);
        LottoResult lottoResult = winnerService.getLottoResult();

        winnerService.announceWinner(lottos);
        displayWinningStatistics(lottoResult);

        ReturnRate returnRate = new ReturnRate(lottoResult);
        Output.displayTotalReturnRate(returnRate.calculateReturnRate(priceInput));

        Input.close();
    }

    private void displayWinningStatistics(LottoResult lottoResult) {
        Output.displayWinningStatisticsHeader();
        for (LottoWinning winning : LottoWinning.values()) {
            if (winning == LottoWinning.FIVE_MATCH_WITH_BONUS_NUMBER) {
                Output.displayMatchCountWithBonus(winning, lottoResult.getCount(winning));
                continue;
            }
            Output.displayMatchCount(winning, lottoResult.getCount(winning));
        }
    }

    private Winner getWinner() {
        while (true) {
            try {
                Output.promptEnterWinningNumber();
                List<Integer> winningNumbers = Input.getWinningNumbersInput();
                Lotto lotto = new Lotto(winningNumbers);

                Output.promptEnterBonusNumber();
                int bonusNumber = Input.getBonusNumberInput();

                return new Winner(lotto, bonusNumber);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayPurchasedLottos(List<Lotto> lottos) {
        Output.displayPurchasedCount(lottos.size());
        Output.displayLottos(lottos);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                Output.promptEnterPurchaseAmount();
                return Input.getPriceInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
