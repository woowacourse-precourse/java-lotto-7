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
import lotto.view.response.LottoProfitResponse;
import lotto.view.response.LottoScoreResponses;
import lotto.view.response.PurchaseLottoResponse;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final RandomNumberGenerator randomNumberGenerator = new DefaultRandomNumberGenerator();
    private final LottoShop lottoShop = new LottoShop();

    private int purchaseMoney;

    public void run() {
        Lottos lottos = Retryer.retryOnCustomException(this::purchaseLotto);

        outputView.printPurchasedLottos(PurchaseLottoResponse.from(lottos));

        WinningLotto winningLotto = Retryer.retryOnCustomException(this::createWinningLotto);

        List<Score> scores = lottos.calculateScore(winningLotto);

        outputView.printScores(LottoScoreResponses.from(Score.aggregate(scores)));
        outputView.printProfitRate(LottoProfitResponse.of(scores, purchaseMoney));
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
}
