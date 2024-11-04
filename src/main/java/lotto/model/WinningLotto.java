package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusBall bonusBall;

    private WinningLotto(Lotto lotto, BonusBall bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto createWinningLotto(List<Integer> numbers, int number) {
        Lotto manualLotto = Lotto.createManualLotto(numbers);
        BonusBall manualBonusBall = BonusBall.createManualBonusBall(number, manualLotto);

        return new WinningLotto(manualLotto, manualBonusBall);
    }

}
