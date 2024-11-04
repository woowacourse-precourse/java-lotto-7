package lotto.function.winning.register;

import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.function.winning.register.processor.BonusLottoNumberInputProcessor;
import lotto.function.winning.register.processor.WinningLottoNumbersInputProcessor;
import lotto.function.winning.register.processor.WinningLottoSaveProcessor;

public class WinningLottoRegister {

    private final WinningLottoNumbersInputProcessor winningLottoNumbersInputProcessor;
    private final BonusLottoNumberInputProcessor bonusLottoNumberInputProcessor;
    private final WinningLottoSaveProcessor winningLottoSaveProcessor;

    public WinningLottoRegister(
            WinningLottoNumbersInputProcessor winningLottoNumbersInputProcessor,
            BonusLottoNumberInputProcessor bonusLottoNumberInputProcessor,
            WinningLottoSaveProcessor winningLottoSaveProcessor
    ) {
        this.winningLottoNumbersInputProcessor = winningLottoNumbersInputProcessor;
        this.bonusLottoNumberInputProcessor = bonusLottoNumberInputProcessor;
        this.winningLottoSaveProcessor = winningLottoSaveProcessor;
    }

    public void run() {
        Lotto firstPlaceLotto = winningLottoNumbersInputProcessor.inputWinningLottoNumbers();
        BonusLotto bonusLotto = bonusLottoNumberInputProcessor.inputBonusLottoNumber();
        WinningLotto winningLotto = new WinningLotto(firstPlaceLotto, bonusLotto);
        winningLottoSaveProcessor.saveWinningLotto(winningLotto);
    }

}
