package lotto.model;

public class LottoResultManager {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoResultManager(Lotto winningNumbers, BonusNumber bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
