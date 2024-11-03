package lotto;

import java.util.List;
import lotto.io.input.Input;
import lotto.io.output.Output;
import lotto.lotto.Lotto;
import lotto.lotto.LottoService;
import lotto.lotto.LottoWinning;
import lotto.random.RandomImpl;
import lotto.returnrate.ReturnRate;
import lotto.winner.Winner;
import lotto.winner.WinnerService;

public class Game {

    private final static LottoService lottoService = new LottoService(new RandomImpl());

    public static void run() {
        int priceInput = getPurchaseAmount();
        List<Lotto> lottos = lottoService.purchaseLottoWithAmount(priceInput);

        displayPurchasedLottos(lottos);

        Winner winner = getWinner();
        WinnerService winnerService = new WinnerService(winner);

        winnerService.announceWinner(lottos);
        displayWinningStatistics();

        double returnRate = ReturnRate.calculateReturnRate(priceInput);
        Output.displayTotalReturnRate(returnRate);

        Input.close();
    }

    private static void displayWinningStatistics() {
        Output.displayWinningStatisticsHeader();
        for (LottoWinning winning : LottoWinning.values()) {
            if (winning == LottoWinning.FIVE_MATCH_WITH_BONUS_NUMBER) {
                Output.displayMatchCountWithBonus(winning);
                continue;
            }
            Output.displayMatchCount(winning);
        }
    }

    private static Winner getWinner() {
        Output.promptEnterWinningNumber();
        List<Integer> winningNumbers = Input.getWinningNumbersInput();
        Lotto lotto = new Lotto(winningNumbers);

        Output.promptEnterBonusNumber();
        int bonusNumber = Input.getBonusNumberInput();

        return new Winner(lotto, bonusNumber);
    }

    private static void displayPurchasedLottos(List<Lotto> lottos) {
        Output.displayPurchasedCount(lottos.size());
        Output.displayLottos(lottos);
    }

    private static int getPurchaseAmount() {
        Output.promptEnterPurchaseAmount();
        return Input.getPriceInput();
    }
}
