package lotto.domain;

import java.util.List;

public class Purchase {
    private final List<Lotto> boughtLottos;

    public Purchase(List<Lotto> boughtLottos) {
        this.boughtLottos = boughtLottos;
    }

    public void checkEachLottosResult(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : boughtLottos) {
            lotto.getResult(winningNumbers, bonusNumber);
        }
    }

    public List<Lotto> getBoughtLottos() {
        return boughtLottos;
    }
}
