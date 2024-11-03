package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.Lottery;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.NumberGenerator;
import lotto.domain.PurchasePrice;
import lotto.domain.Quantity;
import lotto.support.IntegerConverter;
import lotto.support.Splitter;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        // 로또 구입 금액
        Quantity quantity = calculateQuantity(inputView, outputView);
        outputView.showQuantity(quantity.getQuantity());

        // 로또 발행
        List<Lotto> lottos = drawLottos(quantity);
        for (Lotto lotto : lottos) {
            outputView.showLotto(lotto.getNumbers());
        }

        // 당첨 번호
        IntegerConverter converter = new IntegerConverter();
        Lotto winningLotto = makeWinningLotto(inputView, outputView, converter);

        // 보너스 번호
        LottoNumber bonusNumber = makeBonusNumber(inputView, outputView, converter);

        // 당첨 통계
        outputView.showCommentForWinningResult();
        Lottery lottery = new Lottery(winningLotto, bonusNumber, lottos);
        getLottoResult(outputView, lottery);
        calculateProfitRate(outputView, lottery);
    }

    private static void calculateProfitRate(final OutputView outputView, final Lottery lottery) {
        BigDecimal profitRate = lottery.calculateProfitRate();
        outputView.showProfitRate(profitRate);
    }

    private static void getLottoResult(final OutputView outputView, final Lottery lottery) {
        LottoResult lottoResult = lottery.getLottoResult();
        Map<LottoRank, BigDecimal> result = lottoResult.getResult();
        for (int i = LottoRank.values().length - 1; i >= 0; i--) {
            LottoRank lottoRank = LottoRank.values()[i];
            BigDecimal count = result.get(lottoRank);
            outputView.showCommentForMatchingCount(lottoRank.getMatchingCount());
            if (lottoRank == LottoRank.SECOND) {
                outputView.showWinningResultForSecond(lottoRank.getAward(), count);
                continue;
            }
            outputView.showWinningResult(lottoRank.getAward(), count);
        }
    }

    private static LottoNumber makeBonusNumber(final InputView inputView, final OutputView outputView,
                                               final IntegerConverter converter) {
        outputView.showCommentForBonusNumber();
        String inputBonusNumber = inputView.readLine();
        int convertedBonusNumber = converter.convertFrom(inputBonusNumber);
        return new LottoNumber(convertedBonusNumber);
    }

    private static Lotto makeWinningLotto(final InputView inputView, final OutputView outputView,
                                          final IntegerConverter converter) {
        outputView.showCommentForWinningLotto();
        String inputWinningNumbers = inputView.readLine();
        Splitter splitter = new Splitter(",");
        List<String> split = splitter.split(inputWinningNumbers);
        List<Integer> numbers = converter.convertFrom(split);
        return new Lotto(numbers);
    }

    private static List<Lotto> drawLottos(final Quantity quantity) {
        NumberGenerator<?> generator = new LottoNumberGenerator();
        return Lotto.createAsMuchAs(quantity, generator);
    }

    private static Quantity calculateQuantity(final InputView inputView, final OutputView outputView) {
        outputView.showCommentForPurchasePrice();
        String inputPrice = inputView.readLine();
        PurchasePrice purchasePrice = new PurchasePrice(inputPrice);
        return purchasePrice.calculateQuantity();
    }
}
