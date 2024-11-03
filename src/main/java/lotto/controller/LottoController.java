package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.dto.LottoPrizesRecord;
import lotto.domain.LottoTickets;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
import lotto.utils.LottoExceptionUtils;
import lotto.utils.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void runLotto() {
        LottoPrice lottoPurchaseAmount = getLottoPurchaseAmount();
        LottoTickets lottoTickets = generateLottoTickets(lottoPurchaseAmount);
        OutputView.printLottoTickets(lottoTickets);

        WinningLotto winningLotto = inputWinningLotto();
        LottoPrizesRecord lottoPrizesRecord = new LottoPrizesRecord(lottoTickets.getLottoPrizesMap(winningLotto));
        OutputView.printLottoResultsWithStatistics(lottoPrizesRecord, lottoPurchaseAmount);
    }

    private LottoPrice getLottoPurchaseAmount() {
        return LottoExceptionUtils.runUntilNoneLottoException(InputView::inputLottoPrice);
    }

    private LottoTickets generateLottoTickets(LottoPrice lottoPurchaseAmount) {
        return LottoGenerator.generateLottoTickets(lottoPurchaseAmount.getCanPurchaseLottoCount());
    }

    private WinningLotto inputWinningLotto() {
        Lotto wonLotto = LottoExceptionUtils.runUntilNoneLottoException(InputView::wonLottoNumbers);
        Number bonusNumber = LottoExceptionUtils.runUntilNoneLottoException(InputView::inputBonusNumber);
        return new WinningLotto(wonLotto, bonusNumber);
    }
}