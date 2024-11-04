package lotto.application.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lotto.application.model.Lotto;
import lotto.application.model.WinningRanking;

public class LottoAnchor {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoAnchor() {}

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

}
