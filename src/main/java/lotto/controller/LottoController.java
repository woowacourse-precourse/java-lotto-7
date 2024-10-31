package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMaker;
import lotto.model.Score;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoMaker lottoMaker = new LottoMaker();

    private int purchaseMoney;

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        outputView.printPurchasedLottos(lottos);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        List<Score> scores = lottos.stream().map(lotto -> Score.calculateScore(lotto, winningLotto)).toList();

        double profitRate = (double) scores.stream().mapToInt(Score::getPrize).sum() / purchaseMoney * 100;
    }

    public List<Lotto> purchaseLotto() {
        try {
            purchaseMoney = inputView.inputPurchaseMoney();
            return lottoMaker.makeLottos(purchaseMoney);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return purchaseLotto();
        }
    }
}
