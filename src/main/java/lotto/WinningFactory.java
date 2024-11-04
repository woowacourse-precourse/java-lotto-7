package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningFactory {

    public WinningFactory() {

    }

    public WinningTypes createWinningTypes() {
        Map<Integer, WinningType> winningTypes = new HashMap<>();
        winningTypes.put(3, new WinningType(5000));
        winningTypes.put(4, new WinningType(50000));
        winningTypes.put(5, new WinningType(1500000));
        winningTypes.put(6, new WinningType(2000000000));

        WinningType bonusWinning = new WinningType(30000000);
        return new WinningTypes(winningTypes, bonusWinning);
    }
}
