package lotto.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoRank;
import lotto.domain.price.Price;
import lotto.domain.quantity.Quantity;
import lotto.support.converter.Converter;
import lotto.support.splitter.Splitter;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Converter converter;
    private final Splitter splitter;

    public LottoController(final InputView inputView, final OutputView outputView, final Converter converter,
                           final Splitter splitter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.converter = converter;
        this.splitter = splitter;
    }

    public void process() {
        Quantity quantity = calculateQuantity();
        List<Lotto> lottos = generateLottos(quantity);

        Lotto winningLotto = makeWinningLotto();
        LottoNumber bonusNumber = makeBonusNumber();

        Lottery lottery = new Lottery(winningLotto, bonusNumber, lottos);
        showLotteryReport(lottery);
    }

    private Quantity calculateQuantity() {
        Price price = makePrice();
        Quantity quantity = price.calculateQuantity();
        showQuantity(quantity);
        return quantity;
    }

    private Price makePrice() {
        outputView.showCommentForPrice();
        return new Price(converter.convertToBigDecimal(inputView.readLine()));
    }

    private void showQuantity(final Quantity quantity) {
        outputView.showQuantity(quantity.getQuantity());
    }

    private List<Lotto> generateLottos(final Quantity quantity) {
        List<Lotto> lottos = Lotto.createMultipleLottos(quantity);
        showLottos(lottos);
        return lottos;
    }

    private void showLottos(final List<Lotto> lottos) {
        lottos.forEach(lotto -> outputView.showLotto(lotto.getNumbers()));
    }

    private Lotto makeWinningLotto() {
        outputView.showCommentForWinningLotto();
        List<String> numbers = splitter.split(inputView.readLine());
        return new Lotto(converter.convertToInteger(numbers));
    }

    private LottoNumber makeBonusNumber() {
        outputView.showCommentForBonusNumber();
        String inputBonusNumber = inputView.readLine();
        return LottoNumber.valueOf(converter.convertToInteger(inputBonusNumber));
    }

    private void showLotteryReport(final Lottery lottery) {
        outputView.showCommentForWinningResults();
        showWinningResults(lottery);
        showProfitRate(lottery);
    }

    private void showWinningResults(final Lottery lottery) {
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.comparing(LottoRank::getMatchCount))
                .forEach(lottoRank -> {
                    outputView.showWinningResult(lottoRank, lottery.get(lottoRank));
                });
    }

    private void showProfitRate(final Lottery lottery) {
        outputView.showProfitRate(lottery.calculateProfitRate());
    }
}
