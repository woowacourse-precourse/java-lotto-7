package controller;

import java.math.BigDecimal;
import java.util.List;
import lotto.LottoPurchaseInfo;
import lotto.LottoResult;
import lotto.Lottos;
import lotto.generator.RandomNumberGenerator;
import lotto.service.LottoService;
import view.InputView;
import view.OutputView;

public class LottoController {

    InputView inputView;
    OutputView outputView;
    LottoService lottoService;
    RandomNumberGenerator randomNumberGenerator;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService,
                           RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startLottoGame() {
        BigDecimal purchaseAmount = readPurchaseAmount();
        BigDecimal purchaseQuantity = calculateAndPrintPurchaseQuantity(purchaseAmount);

        Lottos lottos = generateAndPrintLottos(purchaseQuantity);

        LottoPurchaseInfo lottoPurchaseInfo = createLottoPurchaseInfo(purchaseAmount);

        LottoResult lottoResult = calculateAndPrintLottoResult(lottos, lottoPurchaseInfo);

        calculateAndPrintReturnOnInvestment(lottoPurchaseInfo, lottoResult);
    }

    private BigDecimal readPurchaseAmount() {
        OutputView.printPurchaseAmountMessage();
        return InputView.readPurchaseAmount();
    }

    private BigDecimal calculateAndPrintPurchaseQuantity(BigDecimal purchaseAmount) {
        BigDecimal purchaseQuantity = lottoService.calculatePurchaseQuantity(purchaseAmount);
        outputView.printPurchaseQuantity(purchaseQuantity);
        return purchaseQuantity;
    }

    private Lottos generateAndPrintLottos(BigDecimal purchaseQuantity) {
        Lottos lottos = Lottos.of(purchaseQuantity, randomNumberGenerator);
        outputView.printLottos(lottos.getLottos());
        return lottos;
    }

    private LottoPurchaseInfo createLottoPurchaseInfo(BigDecimal purchaseAmount) {
        OutputView.printLottoNumbersMessage();
        List<Integer> lottoNumbers = InputView.readLottoNumbers();
        OutputView.printBonusNumberMessage();
        int bonusNumber = InputView.readBonusNumber();
        return LottoPurchaseInfo.of(purchaseAmount, lottoNumbers, bonusNumber);
    }

    private LottoResult calculateAndPrintLottoResult(Lottos lottos, LottoPurchaseInfo lottoPurchaseInfo) {
        LottoResult lottoResult = lottoService.calculateLottoResult(
                lottos, lottoPurchaseInfo.getNumbers(), lottoPurchaseInfo.getBonusNumber());
        outputView.printLottoResult(lottoResult);
        return lottoResult;
    }

    private void calculateAndPrintReturnOnInvestment(LottoPurchaseInfo lottoPurchaseInfo, LottoResult lottoResult) {
        BigDecimal returnOnInvestment = lottoService.calculateReturnOnInvestment(lottoPurchaseInfo, lottoResult);
        outputView.printReturnOnInvestment(returnOnInvestment);
    }
}

