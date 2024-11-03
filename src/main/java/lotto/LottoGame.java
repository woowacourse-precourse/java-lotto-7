package lotto;

import java.util.List;
import lotto.input.InputHandler;

public class LottoGame {

    public void run() {
        final int purchaseAmount = InputHandler.inputLottoPurchaseAmount();
        final int lottoAmount = purchaseAmount / 1000;
        final List<Lotto> lottos = LottoGenerator.createLottos(lottoAmount);

        WinningLotto winningLotto = getWinningLotto();
        LottoManager lottoManager = getLottoManager(lottos, winningLotto);
        LottoReferee referee = new LottoReferee(lottoManager);

        referee.judgeWinning();
    }

    private LottoManager getLottoManager(final List<Lotto> lottos, final WinningLotto winningLotto) {
        return new LottoManager(lottos, winningLotto);
    }

    private WinningLotto getWinningLotto() {
        final List<Integer> winningLottoNumbers = InputHandler.inputWinningLottoNumbers();
        final int bonusNumber = InputHandler.inputBonusNumber(winningLottoNumbers);
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }
}
