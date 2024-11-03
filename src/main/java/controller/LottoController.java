package controller;

import java.math.BigDecimal;
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
        String purchaseAmount = readPurchaseAmount();
        int purchaseQuantity = calculateAndPrintPurchaseQuantity(purchaseAmount);

        Lottos lottos = generateAndPrintLottos(purchaseQuantity);

        LottoPurchaseInfo lottoPurchaseInfo = createLottoPurchaseInfo(purchaseAmount);

        LottoResult lottoResult = calculateAndPrintLottoResult(lottos, lottoPurchaseInfo);

        calculateAndPrintReturnOnInvestment(lottoPurchaseInfo, lottoResult);
    }

    private String readPurchaseAmount() {
        return inputView.readInput(OutputView.MESSAGE_PURCHASE_AMOUNT);
    }

    private int calculateAndPrintPurchaseQuantity(String purchaseAmount) {
        int purchaseQuantity = lottoService.calculatePurchaseQuantity(purchaseAmount);
        outputView.printPurchaseQuantity(purchaseQuantity);
        return purchaseQuantity;
    }

    private Lottos generateAndPrintLottos(int purchaseQuantity) {
        Lottos lottos = Lottos.of(purchaseQuantity, randomNumberGenerator);
        outputView.printLottos(lottos.getLottos());
        return lottos;
    }

    private LottoPurchaseInfo createLottoPurchaseInfo(String purchaseAmount) {
        String userLottoNumbers = inputView.readInput(OutputView.MESSAGE_LOTTO_NUMBER);
        String userBonusNumber = inputView.readInput(OutputView.MESSAGE_BONUS_NUMBER);
        return LottoPurchaseInfo.of(purchaseAmount, userLottoNumbers, userBonusNumber);
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

