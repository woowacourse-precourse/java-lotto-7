package lotto;

import java.util.List;
import lotto.input.InputHandler;

public class LottoGame {

    public void run() {
        LottoManager lottoManager = getLottoManager();
        WinningLotto winningLotto = getWinningLotto();
    }

    private LottoManager getLottoManager() {
        final int purchaseAmount = InputHandler.inputLottoPurchaseAmount();
        final int lottoAmount = purchaseAmount / 1000;
        return new LottoManager(lottoAmount);
    }

    private WinningLotto getWinningLotto() {
        final List<Integer> winningLottoNumbers = InputHandler.inputWinningLottoNumbers();
        final int bonusNumber = InputHandler.inputBonusNumber(winningLottoNumbers);
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }
}
