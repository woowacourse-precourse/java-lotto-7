package lotto;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputWinningLotto;
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

        WinningLotto winningLotto = new WinningLotto(new Lotto(inputWinningLotto()),
                inputBonusNumber());

        LottoResults lottoResults = lottoGame.makeLottoResult(winningLotto);

        printResults(lottoResults);
        printRatio(lottoGame.getEarnRate());
    }

    private static LottoGame makeLottoGame() {
        LottoPurchase lottoPurchase = new LottoPurchase(InputView.inputPrice());
        return new LottoGame(lottoPurchase);
    }
}
