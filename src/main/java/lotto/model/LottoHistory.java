package lotto.model;

import java.util.List;

public class LottoHistory {
    private final List<Integer> winningNumberList;
    private final int winningBonusNumber;
    private final List<Lotto> boughtLottoList;

    public LottoHistory(List<Integer> winningNumberList, int winningBonusNumber, List<Lotto> boughtLottoList) {
        List<Lotto> buiedLottoList;
        this.winningNumberList = winningNumberList;
        this.winningBonusNumber = winningBonusNumber;
        this.boughtLottoList = boughtLottoList;
    }
}
