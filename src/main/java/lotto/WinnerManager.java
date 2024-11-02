package lotto;

import input.BonusNumberInputProcessor;
import input.LottoWinnerNumberInputProcessor;
import java.util.List;

public class WinnerManager {

    private final LottoWinnerNumberInputProcessor lottoWinnerNumberInputProcessor;
    private final BonusNumberInputProcessor bonusNumberInputProcessor;
    private Lotto winnerLotto;
    private Integer bonusNumber;

    WinnerManager(LottoWinnerNumberInputProcessor lottoWinnerNumberInputProcessor,
            BonusNumberInputProcessor bonusNumberInputProcessor) {
        this.lottoWinnerNumberInputProcessor = lottoWinnerNumberInputProcessor;
        this.bonusNumberInputProcessor = bonusNumberInputProcessor;
    }

    public void registerWinnerLotto() {
        List<Integer> registedLottoNumber;
        while (true) {
            registedLottoNumber = lottoWinnerNumberInputProcessor.putValue();
            registerBonusNumber();
            try {
                winnerLotto = new Lotto(registedLottoNumber, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void registerBonusNumber() {
        bonusNumber = bonusNumberInputProcessor.putValue();
    }
}
