package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Score;
import lotto.model.WinningLotto;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import lotto.model.number_generator.DefaultRandomNumberGenerator;
import lotto.model.number_generator.RandomNumberGenerator;
import lotto.model.shop.LottoShop;
import lotto.util.retryer.Retryer;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.response.LottoNumberResponse;
import lotto.view.response.LottoScoreResponse;
import lotto.view.response.LottoScoreResponses;
import lotto.view.response.PurchaseLottoResponse;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final RandomNumberGenerator randomNumberGenerator = new DefaultRandomNumberGenerator();
    private final LottoShop lottoShop = new LottoShop();

    private int purchaseMoney;

    public void run() {
        Lottos lottos = Retryer.retryOnCustomException(this::purchaseLotto);

        outputView.printPurchasedLottos(getPurchaseLottoResponse(lottos));

        WinningLotto winningLotto = Retryer.retryOnCustomException(this::createWinningLotto);

        List<Score> scores = calculateScores(lottos, winningLotto);
        double profitRate = calculateProfitRate(scores);

        LottoScoreResponses lottoScoreResponses = getLottoScoreResponses(scores);

        printResult(lottoScoreResponses, profitRate);
    }

    private Lottos purchaseLotto() {
        purchaseMoney = inputView.inputPurchaseMoney();
        return lottoShop.purchaseRandomLottos(purchaseMoney, randomNumberGenerator);
    }

    private WinningLotto createWinningLotto() {
        List<LottoNumber> winningNumbers = inputView.inputWinningNumbers().stream()
                .map(LottoNumber::from)
                .toList();

        LottoNumber bonusNumber = LottoNumber.from(inputView.inputBonusNumber());

        return new WinningLotto(LottoNumbers.from(winningNumbers), bonusNumber);
    }

    private List<Score> calculateScores(Lottos lottos, WinningLotto winningLotto) {
        return lottos.calculateScore(winningLotto);
    }

    private double calculateProfitRate(List<Score> scores) {
        return (double) scores.stream().mapToInt(Score::getPrize).sum() / purchaseMoney * 100;
    }

    private void printResult(LottoScoreResponses lottoScoreResponses, double profitRate) {
        outputView.printScores(lottoScoreResponses);
        outputView.printProfitRate(profitRate);
    }

    private PurchaseLottoResponse getPurchaseLottoResponse(Lottos lottos) {

        List<LottoNumberResponse> lottoNumberResponses = lottos.getAllLottoNumbers().stream()
                .map(LottoNumberResponse::from)
                .toList();

        return PurchaseLottoResponse.from(lottoNumberResponses);
    }

    private LottoScoreResponses getLottoScoreResponses(List<Score> scores) {
        Map<LottoScoreResponse, Integer> lottoScoreResponses = initializeLottoScoreResponses();

        mergeToLottoScoreResponses(scores, lottoScoreResponses);

        return LottoScoreResponses.from(lottoScoreResponses);
    }

    private Map<LottoScoreResponse, Integer> initializeLottoScoreResponses() {
        Map<LottoScoreResponse, Integer> lottoScoreResponseMap = new LinkedHashMap<>();

        for (Score score : Score.values()) {
            LottoScoreResponse response = LottoScoreResponse.from(score);
            lottoScoreResponseMap.put(response, 0);
        }

        return lottoScoreResponseMap;
    }

    private void mergeToLottoScoreResponses(List<Score> scores, Map<LottoScoreResponse, Integer> lottoScoreResponses) {
        scores.forEach(score ->
                lottoScoreResponses.merge(LottoScoreResponse.from(score), 1, Integer::sum)
        );
    }
}
