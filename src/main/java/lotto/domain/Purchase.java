package lotto.domain;

import java.util.List;

public class Purchase {
    private final List<Lotto> boughtLottos;
    private Lotto winningNumbers;
    private int bonusNumber;

    public Purchase(List<Lotto> boughtLottos) {
        this.boughtLottos = boughtLottos;
    }

}
