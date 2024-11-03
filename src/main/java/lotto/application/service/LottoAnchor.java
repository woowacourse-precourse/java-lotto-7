package lotto.application.service;

import java.util.ArrayList;
import java.util.List;

public class LottoAnchor {

    private List<Integer> winningNumbers;

    public LottoAnchor() {}

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

}
