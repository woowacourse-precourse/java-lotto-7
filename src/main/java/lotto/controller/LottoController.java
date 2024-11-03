package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Score;
import lotto.model.WinningLotto;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import lotto.model.number_generator.RandomNumberGenerator;
import lotto.model.shop.LottoShop;
import lotto.util.retryer.Retryer;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.response.LottoProfitResponse;
import lotto.view.response.LottoScoreResponses;
import lotto.view.response.PurchaseLottoResponse;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final RandomNumberGenerator randomNumberGenerator;
    private final LottoShop lottoShop;

    public LottoController(InputView inputView,
                           OutputView outputView,
                           RandomNumberGenerator randomNumberGenerator,
                           LottoShop lottoShop) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;
        this.lottoShop = lottoShop;
    }

    public void run() {
        AtomicInteger purchaseMoney = new AtomicInteger();

        Lottos lottos = Retryer.retryOnCustomException(() -> {
            purchaseMoney.set(inputView.inputPurchaseMoney());
            return lottoShop.purchaseRandomLottos(purchaseMoney.get(), randomNumberGenerator);
        });

        outputView.printPurchasedLottos(PurchaseLottoResponse.from(lottos));

        WinningLotto winningLotto = Retryer.retryOnCustomException(this::createWinningLotto);

        List<Score> scores = lottos.calculateScore(winningLotto);

        outputView.printScores(LottoScoreResponses.from(Score.aggregate(scores)));
        outputView.printProfitRate(LottoProfitResponse.of(scores, purchaseMoney.get()));
    }

    private WinningLotto createWinningLotto() {
        List<LottoNumber> winningNumbers = inputView.inputWinningNumbers().stream()
                .map(LottoNumber::from)
                .toList();

        LottoNumber bonusNumber = LottoNumber.from(inputView.inputBonusNumber());

        return new WinningLotto(LottoNumbers.from(winningNumbers), bonusNumber);
    }
}
