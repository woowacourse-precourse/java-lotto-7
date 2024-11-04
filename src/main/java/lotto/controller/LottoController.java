package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.BonusLottoNumberInput;
import lotto.dto.LottoPurchasedAmountInput;
import lotto.dto.WinnerLottoNumbersInput;
import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoReport;
import lotto.model.NumberStringConverter;
import lotto.model.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Buyer;
import lotto.model.YieldAnalyst;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final YieldAnalyst yieldAnalyst;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final NumberStringConverter numberStringConverter;

    public LottoController(InputView inputView, OutputView outputView, YieldAnalyst yieldAnalyst,
                           LottoNumberGenerator lottoNumberGenerator, NumberStringConverter numberStringConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.yieldAnalyst = yieldAnalyst;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.numberStringConverter = numberStringConverter;
    }

    public void start() {
        outputView.printPurchaseAmountPrompt();
        Buyer buyer = processLottoPurchase();

        outputView.printNumberOfPurchasedLottos(buyer.getNumberOfLottos());
        List<Lotto> purchasedLottoList = IntStream.range(0, buyer.getNumberOfLottos())
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
        outputView.printLottoList(purchasedLottoList);

        outputView.printWinningNumbersPrompt();
        WinnerLotto winnerLotto = processWinnerLotto();

        outputView.printBonusNumberPrompt();
        processBonusNumber(winnerLotto);

        LottoReport lottoReport = LottoReport.of(purchasedLottoList, winnerLotto);
        outputView.printReport(lottoReport.getMatchCountMap());

        double yield = yieldAnalyst.calculateYield(buyer.getPurchaseAmount(), lottoReport.getTotalEarnings());
        outputView.printYield(yield);
    }

    private Buyer processLottoPurchase() {
        while (true) {
            try {
                LottoPurchasedAmountInput lottoPurchasedAmountInput = inputView.readLottoPurchasedAmount();
                return Buyer.from(lottoPurchasedAmountInput.rawAmount());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinnerLotto processWinnerLotto() {
        while (true) {
            try {
                WinnerLottoNumbersInput winnerLottoNumbersInput = inputView.readWinnerLottoNumbers();

                List<Integer> winningNumbers = Arrays.stream(winnerLottoNumbersInput.rawNumbers().split(","))
                        .map(numberStringConverter::convert).toList();

                return WinnerLotto.from(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void processBonusNumber(WinnerLotto winnerLotto) {
        while (true) {
            try {
                BonusLottoNumberInput bonusLottoNumberInput = inputView.readBonusLottoNumber();

                int bonusNumber = numberStringConverter.convert(bonusLottoNumberInput.rawNumber());

                winnerLotto.setBonusNumber(bonusNumber);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
