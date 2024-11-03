package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.BonusLottoNumBerInput;
import lotto.dto.LottoPurchasedAmountInput;
import lotto.dto.WinnerLottoNumbersInput;
import lotto.exception.LottoException;
import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoReport;
import lotto.model.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Buyer;
import lotto.model.YieldAnalyst;

public class LottoController {

    private final InputView inputView;
    private final OutputView outPutView;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final YieldAnalyst yieldAnalyst;

    public LottoController(InputView inputView, OutputView outPutView, LottoNumberGenerator lottoNumberGenerator,
                           YieldAnalyst yieldAnalyst) {
        this.inputView = inputView;
        this.outPutView = outPutView;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.yieldAnalyst = yieldAnalyst;
    }

    public void start() {
        outPutView.printPurchaseAmountPrompt();
        Buyer buyer = processLottoPurchase();

        outPutView.printNumberOfPurchasedLottos(buyer.getNumberOfLottos());
        List<Lotto> purchasedLottoList = IntStream.range(0, buyer.getNumberOfLottos())
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
        outPutView.printLottoList(purchasedLottoList);

        outPutView.printWinningNumbersPrompt();
        WinnerLotto winnerLotto = processWinnerLotto();

        outPutView.printBonusNumberPrompt();
        processBonusNumber(winnerLotto);

        LottoReport lottoReport = LottoReport.of(purchasedLottoList, winnerLotto);
        outPutView.printReport(lottoReport.getMatchCountMap());

        double yield = yieldAnalyst.calculateYield(buyer.getPurchaseAmount(), lottoReport.getTotalEarnings());
        outPutView.printYield(yield);
    }

    private Buyer processLottoPurchase() {
        while (true) {
            try {
                LottoPurchasedAmountInput lottoPurchasedAmountInput = inputView.readLottoPurchasedAmount();

                return Buyer.from(lottoPurchasedAmountInput.rawAmount());
            } catch (LottoException e) {
                outPutView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinnerLotto processWinnerLotto() {
        while (true) {
            try {
                WinnerLottoNumbersInput winnerLottoNumbersInput = inputView.readWinnerLottoNumbers();
                return WinnerLotto.from(winnerLottoNumbersInput.rawNumbers());
            } catch (LottoException e) {
                outPutView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void processBonusNumber(WinnerLotto winnerLotto) {
        while (true) {
            try {
                BonusLottoNumBerInput bonusLottoNumBerInput = inputView.readBonusLottoNumber();
                winnerLotto.setBonusNumber(bonusLottoNumBerInput.rawNumber());
                return;
            } catch (LottoException e) {
                outPutView.printErrorMessage(e.getMessage());
            }
        }
    }
}
