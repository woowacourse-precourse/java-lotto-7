package lotto.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoRank;
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
    private final Splitter splitter;

    public LottoController(final InputView inputView, final OutputView outputView, final IntegerConverter converter,
                           final Splitter splitter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.converter = converter;
        this.splitter = splitter;
    }

    public void process() {
        Quantity quantity = calculateQuantity();
        List<Lotto> drawnLottos = drawLottos(quantity);

        Lotto winningLotto = makeWinningLotto();
        LottoNumber bonusNumber = makeBonusNumber();

        Lottery lottery = new Lottery(winningLotto, bonusNumber, drawnLottos);
        getWinningResults(lottery);
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
        List<Lotto> lottos = Lotto.makeAsMuchAs(quantity.getQuantity());
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
        return LottoNumber.valueOf(converter.convertFrom(inputBonusNumber));
    }

    private void getWinningResults(final Lottery lottery) {
        outputView.showCommentForWinningResults();
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.comparing(LottoRank::getMatchCount))
                .forEach(lottoRank -> {
                    BigDecimal count = lottery.get(lottoRank);
                    outputView.showWinningResult(lottoRank, count);
                });
        outputView.showProfitRate(lottery.calculateProfitRate());
    }
}
