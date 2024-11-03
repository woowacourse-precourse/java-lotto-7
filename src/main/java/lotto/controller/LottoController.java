package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoResult;
import lotto.support.generator.NumberGenerator;
import lotto.domain.price.PurchasePrice;
import lotto.domain.quantity.Quantity;
import lotto.support.converter.IntegerConverter;
import lotto.support.splitter.Splitter;
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
        Quantity quantity = calculateQuantity();
        List<Lotto> drawnLottos = drawLottos(quantity);

        Lotto winningLotto = makeWinningLotto();
        LottoNumber bonusNumber = makeBonusNumber();

        Lottery lottery = new Lottery(winningLotto, bonusNumber, drawnLottos);
        getLottoResult(lottery.getLottoResult());
        calculateProfitRate(lottery.calculateProfitRate());
    }

    private Quantity calculateQuantity() {
        outputView.showCommentForPurchasePrice();
        String inputPrice = inputView.readLine();
        PurchasePrice purchasePrice = new PurchasePrice(inputPrice);
        Quantity quantity = purchasePrice.calculateQuantity();
        outputView.showQuantity(quantity.getQuantity());
        return quantity;
    }

    private List<Lotto> drawLottos(final Quantity quantity) {
        List<Lotto> lottos = Lotto.makeAsMuchAs(generator.generateNumbersBy(quantity.getQuantity()));
        for (Lotto lotto : lottos) {
            outputView.showLotto(lotto.getNumbers());
        }
        return lottos;
    }

    private Lotto makeWinningLotto() {
        outputView.showCommentForWinningLotto();
        String inputNumbers = inputView.readLine();
        List<Integer> numbers = converter.convertFrom(splitter.split(inputNumbers));
        return new Lotto(numbers);
    }

    private LottoNumber makeBonusNumber() {
        outputView.showCommentForBonusNumber();
        String inputBonusNumber = inputView.readLine();
        return new LottoNumber(converter.convertFrom(inputBonusNumber));
    }

    private void getLottoResult(final LottoResult lottoResult) {
        outputView.showCommentForLottoResult();
        for (int i = LottoRank.values().length - 1; i >= 0; i--) {
            LottoRank lottoRank = LottoRank.values()[i];
            BigDecimal count = lottoResult.get(lottoRank);
            outputView.showCommentForMatchingCount(lottoRank.getMatchingCount());
            if (lottoRank == LottoRank.SECOND) {
                outputView.showLottoResultForSecond(lottoRank.getAward(), count);
                continue;
            }
            outputView.showLottoResult(lottoRank.getAward(), count);
        }
    }

    private void calculateProfitRate(final BigDecimal profitRate) {
        outputView.showProfitRate(profitRate);
    }
}
