package lotto.controller;

import lotto.config.LottoGameConfig;
import lotto.exception.LottoGameException;
import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumbers;
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

}
