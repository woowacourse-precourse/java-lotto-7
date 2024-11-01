package lotto.controller;

import lotto.model.*;
import lotto.util.retryer.Retryer;
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
        Lottos lottos = Retryer.retryOnCustomException(this::purchaseLotto);
        outputView.printPurchasedLottos(lottos);

        WinningLotto winningLotto = Retryer.retryOnCustomException(this::createWinningLotto);

        Map<Score, Integer> scores = Retryer.retryOnCustomException(() -> calculateScores(lottos, winningLotto));
        double profitRate = Retryer.retryOnCustomException(() -> calculateProfitRate(scores.keySet().stream().toList()));

        printResult(scores, profitRate);
    }

    private Lottos purchaseLotto() {
        purchaseMoney = inputView.inputPurchaseMoney();
        return lottoMaker.makeLottos(purchaseMoney);
    }

    private WinningLotto createWinningLotto() {
        List<LottoNumber> winningNumbers = inputView.inputWinningNumbers().stream()
                .map(LottoNumber::from)
                .toList();

        LottoNumber bonusNumber = LottoNumber.from(inputView.inputBonusNumber());

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Map<Score, Integer> calculateScores(Lottos lottos, WinningLotto winningLotto) {
        List<Score> scores = lottos.calculateResult(winningLotto);

        return scores.stream()
                .collect(
                        LinkedHashMap::new,
                        (map, score) -> map.put(score, map.getOrDefault(score, 0) + 1),
                        Map::putAll
                );
    }

    private double calculateProfitRate(List<Score> scores) {
        return (double) scores.stream().mapToInt(Score::getPrize).sum() / purchaseMoney * 100;
    }

    private void printResult(Map<Score, Integer> scores, double profitRate) {
        outputView.printScores(scores);
        outputView.printProfitRate(profitRate);
    }
}
