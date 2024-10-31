package lotto.controller;

import lotto.config.LottoGameConfig;
import lotto.exception.LottoGameException;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private static final LottoMachine LOTTO_MACHINE = new LottoMachine();

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(LottoGameConfig lottoGameConfig) {
        this.inputView = lottoGameConfig.getInputView();
        this.outputView = lottoGameConfig.getOutputView();
    }

    public void control() {
        outputView.commentsForPurchaseAmount();
        Money userAmount = getPurchaseAmountFromUser();

        int lottoCount = outputView.commentForBuyLotto(userAmount);
        Lottos lottos = LOTTO_MACHINE.generateLottos(lottoCount);
        outputView.commentForLottoList(lottos);

        outputView.getCommentForWinningNumber();
        WinningNumbers winningNumbers = getWinningNumberFromUser();

        outputView.getCommentForBonusNumber();
        int bonusNumber = getBonusNumberFromUser();

        LottoResult lottoResult = LOTTO_MACHINE.getLottoResult(lottos, winningNumbers, bonusNumber);
        outputView.getCommentForStatistics(lottoResult);

        double rateOfReturn = lottoResult.getRateOfReturn(userAmount);
        outputView.getCommentForRateOfReturn(rateOfReturn);
    }

    private Money getPurchaseAmountFromUser() {
        try {
            return inputView.getPurchaseAmountFromUser();
        } catch (LottoGameException e) {
            outputView.commentErrorMessage(e);
            return getPurchaseAmountFromUser();
        }
    }

    private WinningNumbers getWinningNumberFromUser() {
        try {
            return inputView.getWinningNumberFromUser();
        } catch (LottoGameException e) {
            outputView.commentErrorMessage(e);
            return getWinningNumberFromUser();
        }
    }

    private int getBonusNumberFromUser() {
        try {
            return inputView.getBonusNumberFromUser();
        } catch (LottoGameException e) {
            outputView.commentErrorMessage(e);
            return getBonusNumberFromUser();
        }
    }

}
