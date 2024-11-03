package lotto;

import static lotto.view.OutputView.printLottoGames;

import lotto.domain.LottoGame;
import lotto.domain.LottoPurchase;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = makeLottoGame();
        printLottoGames(lottoGame);
    }

    private static LottoGame makeLottoGame() {
        LottoPurchase lottoPurchase = new LottoPurchase(InputView.inputPrice());
        return new LottoGame(lottoPurchase);
    }
}
