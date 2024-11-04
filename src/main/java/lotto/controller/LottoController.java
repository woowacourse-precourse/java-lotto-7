package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.domain.LottoPaper;
import lotto.domain.Payment;
import lotto.exception.LottoException;
import lotto.exception.ParserException;
import lotto.utils.Parser;
import lotto.view.InputReader;
import lotto.view.OutputView;

public class LottoController {

    public LottoController() {
    }

    public LottoPaper purchaseLottoPaper(final Payment payment) {
        LottoPaper lottoPaper = LottoPaper.makeLottoPaper(payment.getLottoCount());
        OutputView.printLottoPaperMessage(lottoPaper);
        return lottoPaper;
    }

    public LottoDraw generateLottoDraw() {
        Lotto winningLotto = getWinningLotto();
        while (true) {
            try {
                int bonusNumber = getBonusNumber();
                return LottoDraw.of(winningLotto, bonusNumber);
            } catch (LottoException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        while(true) {
            try {
                OutputView.printWinningLottoMessage();
                String winningLottoInput = InputReader.readLine();
                List<Integer> winningLotto = Parser.splitBySeparator(winningLottoInput);
                return new Lotto(winningLotto);
            } catch (LottoException | ParserException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                OutputView.printBonusNumberMessage();
                String bonusNumberInput = InputReader.readLine();
                return Parser.parseStringToInt(bonusNumberInput);
            } catch (ParserException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
