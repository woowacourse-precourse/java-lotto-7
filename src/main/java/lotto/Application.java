package lotto;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputWinningLotto;
import static lotto.view.OutputView.printErrorMessage;
import static lotto.view.OutputView.printLottoGames;
import static lotto.view.OutputView.printRatio;
import static lotto.view.OutputView.printResults;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResults;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = makeLottoGame();
        printLottoGames(lottoGame);

        WinningLotto winningLotto = makeWinningLotto();

        LottoResults lottoResults = lottoGame.makeLottoResult(winningLotto);

        printResults(lottoResults);
        printRatio(lottoGame.getEarnRate());
    }

    private static LottoGame makeLottoGame() {
        while (true) {
            try {
                LottoPurchase lottoPurchase = new LottoPurchase(InputView.inputPrice());
                return new LottoGame(lottoPurchase);
            } catch (IllegalArgumentException exception) {
                printErrorMessage(exception.getMessage());
            }
        }

    }

    private static WinningLotto makeWinningLotto() {
        while (true) {
            try {
                return new WinningLotto(new Lotto(inputWinningLotto()),
                        inputBonusNumber());
            } catch (IllegalArgumentException exception) {
                printErrorMessage(exception.getMessage());
            }
        }
    }

}
