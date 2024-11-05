package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningNumbers;
import lotto.dto.PurchasedLottosResponse;
import lotto.dto.WinningSummaryResponse;
import lotto.parser.LottoNumbersInputParser;
import lotto.view.ConsoleView;

import java.util.List;

public class LottoController {
    private final ConsoleView consoleView;

    public LottoController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(purchaseAmount);

        Lotto winningLotto = readWinningLottoNumbers();
        LottoNumber bonusNumber = readBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        WinningSummaryResponse winningSummary = winningNumbers.findWinningResult(purchasedLottos);
        consoleView.printWinningResult(winningSummary);

        double profitRate = calculateProfitRate(purchaseAmount, winningSummary);
        consoleView.printProfitRate(profitRate);
    }

    private PurchaseAmount readPurchaseAmount() {
        int purchaseAmountInput = consoleView.readPurchaseAmountInput();

        return new PurchaseAmount(purchaseAmountInput);
    }

    private List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculatePurchasableLottoCount();
        consoleView.printPurchasableLottoCount(lottoCount);

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> purchasedLottos = lottoGenerator.generateLottos(lottoCount);
        consoleView.printPurchasedLottos(PurchasedLottosResponse.from(purchasedLottos));

        return purchasedLottos;
    }

    private Lotto readWinningLottoNumbers() {
        String winningLottoNumbersInput = consoleView.readWinningLottoNumbersInput();
        LottoNumbersInputParser lottoNumbersInputParser = new LottoNumbersInputParser();
        List<Integer> lottoNumbers = lottoNumbersInputParser.parse(winningLottoNumbersInput);

        return new Lotto(lottoNumbers);
    }

    private LottoNumber readBonusNumber() {
        int bonusNumberInput = consoleView.readBonusNumberInput();

        return new LottoNumber(bonusNumberInput);
    }

    private double calculateProfitRate(PurchaseAmount purchaseAmount, WinningSummaryResponse winningSummaryResponse) {
        int totalProfit = winningSummaryResponse.matchingCountResponses()
                .stream()
                .mapToInt(WinningSummaryResponse.MatchingCountResponse::getProfit)
                .sum();

        return purchaseAmount.calculateProfitRate(totalProfit);
    }
}
