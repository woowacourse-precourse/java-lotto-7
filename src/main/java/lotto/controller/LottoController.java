package lotto.controller;


import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.generator.LottoGenerator;
import lotto.util.LottoParser;
import lotto.validator.LottoPurchasePriceValidator;
import lotto.validator.LottoWinningNumbersValidator;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoPurchasePriceValidator lottoPurchasePriceValidator;
    private final LottoGenerator lottoGenerator;
    private final LottoWinningNumbersValidator lottoWinningNumbersValidator;

    public LottoController(
            LottoView lottoView,
            LottoPurchasePriceValidator lottoPurchasePriceValidator,
            LottoGenerator lottoGenerator,
            LottoWinningNumbersValidator lottoWinningNumbersValidator
    ) {
        this.lottoView = lottoView;
        this.lottoPurchasePriceValidator = lottoPurchasePriceValidator;
        this.lottoGenerator = lottoGenerator;
        this.lottoWinningNumbersValidator = lottoWinningNumbersValidator;
    }

    public void run() {
        int lottoPurchasePrice = retry(this::requestLottoPurchasePrice);
        List<Lotto> lottos = lottoGenerator.generateLottos(lottoPurchasePrice);
        lottoView.printLottos(lottos);
        List<Integer> lottoWinningNumbers = retry(this::requestLottoWinningNumbers);
    }


    private int requestLottoPurchasePrice() {
        String lottoPurchasePrice = lottoView.requestLottoPurchasePrice();
        lottoPurchasePriceValidator.validateLottoPurchasePrice(lottoPurchasePrice);
        return LottoParser.parseInt(lottoPurchasePrice);
    }

    private List<Integer> requestLottoWinningNumbers(){
        String lottoWinningNumbers = lottoView.requestLottoWinningNumbers();
        lottoWinningNumbersValidator.validateLottoWinningNumbers(lottoWinningNumbers);
        return LottoParser.parseNumbers(lottoWinningNumbers);
    }

    private <T> T retry(Supplier<T> logic) {
        boolean retryFlag = true;
        T result = null;
        while (retryFlag) {
            try {
                result = logic.get();
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
