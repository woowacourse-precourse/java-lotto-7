package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.Lottery;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.NumberGenerator;
import lotto.domain.PurchasePrice;
import lotto.domain.Quantity;
import lotto.support.IntegerConverter;
import lotto.support.Splitter;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final IntegerConverter converter;
    private final NumberGenerator<?> generator;
    private final Splitter splitter;

    public LottoController(final InputView inputView, final OutputView outputView, final IntegerConverter converter,
                           final NumberGenerator<?> generator, final Splitter splitter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.converter = converter;
        this.generator = generator;
        this.splitter = splitter;
    }

    public void process() {
        // 로또 구입 금액
        outputView.showCommentForPurchasePrice();
        Quantity quantity = calculateQuantity();
        outputView.showQuantity(quantity.getQuantity());

        // 로또 발행
        List<Lotto> lottos = drawLottos(quantity);
        for (Lotto lotto : lottos) {
            outputView.showLotto(lotto.getNumbers());
        }

        // 당첨 번호
        outputView.showCommentForWinningLotto();
        Lotto winningLotto = makeWinningLotto();

        // 보너스 번호
        outputView.showCommentForBonusNumber();
        LottoNumber bonusNumber = makeBonusNumber();

        // 당첨 통계
        outputView.showCommentForWinningResult();
        Lottery lottery = new Lottery(winningLotto, bonusNumber, lottos);
        getLottoResult(lottery);
        calculateProfitRate(lottery);
    }

    private Quantity calculateQuantity() {
        String inputPrice = inputView.readLine();
        PurchasePrice purchasePrice = new PurchasePrice(inputPrice);
        return purchasePrice.calculateQuantity();
    }

    private List<Lotto> drawLottos(final Quantity quantity) {
        return Lotto.makeAsMuchAs(generator.generateNumbersBy(quantity.getQuantity()));
    }

    private Lotto makeWinningLotto() {
        String inputNumbers = inputView.readLine();
        List<Integer> numbers = converter.convertFrom(splitter.split(inputNumbers));
        return new Lotto(numbers);
    }

    private LottoNumber makeBonusNumber() {
        String inputBonusNumber = inputView.readLine();
        return new LottoNumber(converter.convertFrom(inputBonusNumber));
    }

    private void getLottoResult(final Lottery lottery) {
        LottoResult lottoResult = lottery.getLottoResult();
        for (int i = LottoRank.values().length - 1; i >= 0; i--) {
            LottoRank lottoRank = LottoRank.values()[i];
            BigDecimal count = lottoResult.get(lottoRank);
            outputView.showCommentForMatchingCount(lottoRank.getMatchingCount());
            if (lottoRank == LottoRank.SECOND) {
                outputView.showWinningResultForSecond(lottoRank.getAward(), count);
                continue;
            }
            outputView.showWinningResult(lottoRank.getAward(), count);
        }
    }

    private void calculateProfitRate(final Lottery lottery) {
        BigDecimal profitRate = lottery.calculateProfitRate();
        outputView.showProfitRate(profitRate);
    }
}
