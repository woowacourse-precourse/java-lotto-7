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

public class LottoController {

    private final InputView inputView;
    private final OutputView outPutView;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(InputView inputView, OutputView outPutView, LottoNumberGenerator lottoNumberGenerator) {
        this.inputView = inputView;
        this.outPutView = outPutView;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void start() {
        Buyer buyer = processLottoPurchase();
        WinnerLotto winnerLotto = processWinnerLotto();
        processBonusNumber(winnerLotto);

        outPutView.printNumberOfPurchasedLottos(buyer.getNumberOfLottos());

        List<Lotto> purchasedLottoList = IntStream.range(0, buyer.getNumberOfLottos())
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();

        outPutView.printLottoList(purchasedLottoList);

        LottoReport lottoReport = LottoReport.of(purchasedLottoList, winnerLotto);

        outPutView.printReport(lottoReport.getMatchCountMap());
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
