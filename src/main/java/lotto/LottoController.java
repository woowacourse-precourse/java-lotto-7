package lotto;

import java.util.List;

public class LottoController {
    private final LottoGame lottoGame;

    public LottoController() {
        this.lottoGame = new LottoGame();
    }

    public void startGame() {
        int lottoPurchase = LottoInputView.lottoPurchaseAmount();
        List<Lotto> makePurchasedLottos = LottoFactory.createLottos(count(lottoPurchase));
        LottoOutputView.printPurchasedLottoCount(makePurchasedLottos);

        List<Integer> winningNumbers = LottoInputView.lottoWinningNumbers();
        // 보너스 번호 입력받는다.
        int bonusNumber = LottoInputView.lottoBonusNumber(winningNumbers);
        lottoGame.setLottoGame(new Lotto(winningNumbers), bonusNumber);
        lottoGame.calculateLotto(makePurchasedLottos);

        LottoOutputView.printResult(lottoGame.getResult());
        LottoOutputView.printrateOfReturn(lottoGame.rateOfReturn(lottoPurchase));
    }

    public int count (int lottoPurchase) {
        return (lottoPurchase / 1000);
    }
}
