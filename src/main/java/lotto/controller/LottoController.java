package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoMaker lottoMaker = new LottoMaker();

    private int purchaseMoney;

    public void run() {
        Lottos lottos = purchaseLotto();
        outputView.printPurchasedLottos(lottos);

        List<LottoNumber> winningNumbers = inputView.inputWinningNumbers().stream().map(LottoNumber::from).toList();
        LottoNumber bonusNumber = LottoNumber.from(inputView.inputBonusNumber());

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        List<Score> scores = lottos.getLottos().stream().map(lotto -> Score.calculateScore(lotto, winningLotto)).toList();

        double profitRate = (double) scores.stream().mapToInt(Score::getPrize).sum() / purchaseMoney * 100;

        Map<Score, Integer> scoreMap = new LinkedHashMap<>();
        scores.forEach(score -> {
            scoreMap.put(score, scoreMap.getOrDefault(score, 0) + 1);
        });

        outputView.printScores(scoreMap);
        outputView.printProfitRate(profitRate);
    }

    public Lottos purchaseLotto() {
        try {
            purchaseMoney = inputView.inputPurchaseMoney();
            return lottoMaker.makeLottos(purchaseMoney);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return purchaseLotto();
        }
    }
}
