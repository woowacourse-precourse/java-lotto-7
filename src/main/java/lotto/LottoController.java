package lotto;

import java.util.List;

public class LottoController {
    private final LottoGame lottoGame;

    public LottoController() {
        this.lottoGame = new LottoGame();
    }

    public void startGame() {
        int lottoPurchase = LottoInputView.lottoPurchaseAmount();
        List<Lotto> makePurchasedLottos = createLottos(lottoPurchase);
        LottoOutputView.printPurchasedLottoCount(makePurchasedLottos);
        List<Integer> winningNumbers = LottoInputView.lottoWinningNumbers();
        int bonusNumber = LottoInputView.lottoBonusNumber(winningNumbers);
        lottoGame.setLottoGame(new Lotto(winningNumbers), bonusNumber);
        lottoGame.calculateLotto(makePurchasedLottos);
        LottoOutputView.printResult(lottoGame.getResult());
        LottoOutputView.printrateOfReturn(lottoGame.rateOfReturn(lottoPurchase));
    }

    // 로또를 생성하는 함수
    private List<Lotto> createLottos(int lottoPurchase) {
        return LottoFactory.createLottos(count(lottoPurchase));
    }

    public int count (int lottoPurchase) {
        return (lottoPurchase / 1000);
    }
}
